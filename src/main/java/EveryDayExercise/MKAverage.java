package EveryDayExercise;

import org.junit.Test;

import java.util.*;

public class MKAverage {

    int m;
    int k;
    Queue<Integer> data;
    TreeMap<Integer,Integer> low;
    int size1;
    TreeMap<Integer,Integer> mid;
    int size2;
    TreeMap<Integer,Integer> high;
    int size3;
    int sum;

    public MKAverage(int m, int k) {
        this.m=m;
        this.k=k;
        data=new LinkedList<>();
        low=new TreeMap<>();
        mid=new TreeMap<>();
        high=new TreeMap<>();
        sum=0;
        size1=0;
        size2=0;
        size3=0;
    }

    public void addElement(int num) {
        if(data.size()>=m){
            Integer poll = data.poll();
            if(low.containsKey(poll)){
                Integer sum = low.get(poll);
                if(sum==1){
                    low.remove(poll);
                }else{
                    low.put(poll,sum-1);
                }
                size1--;
                if(size1<k){
                    if(size2>0){
                        Integer firstKey = mid.firstKey();
                        Integer firstValue = mid.get(firstKey);
                        if(firstValue==1){
                            mid.remove(firstKey);
                        }else{
                            mid.put(firstKey,firstValue-1);
                        }
                        low.put(firstKey,low.getOrDefault(firstKey,0)+1);
                        size2--;
                        size1++;
                        this.sum-=firstKey;
                    }
                }
            }else if(high.containsKey(poll)){
                Integer sum = high.get(poll);
                if(sum==1){
                    high.remove(poll);
                }else{
                    high.put(poll,sum-1);
                }
                size3--;
                if(size3<k){
                    if(size2>0){
                        Integer lastKey = mid.lastKey();
                        Integer lastValue = mid.get(lastKey);
                        if(lastValue==1){
                            mid.remove(lastKey);
                        }else{
                            mid.put(lastKey,lastValue-1);
                        }
                        high.put(lastKey,high.getOrDefault(lastKey,0)+1);
                        size2--;
                        size3++;
                        this.sum-=lastKey;
                    }
                }
            }else{
                Integer value = mid.get(poll);
                if(value==1){
                    mid.remove(poll);
                }else{
                    mid.put(poll,value-1);
                }
                size2--;
                this.sum-=poll;
            }
        }
        data.add(num);
        if(size1<k){
            low.put(num,low.getOrDefault(num,0)+1);
            size1++;
        }else{
            if(num>=low.lastKey()){
                if(size3<k){
                    high.put(num,high.getOrDefault(num,0)+1);
                    size3++;
                }else{
                    Integer firstKey = high.firstKey();
                    if(num<firstKey){
                        mid.put(num,mid.getOrDefault(num,0)+1);
                        size2++;
                        this.sum+=num;
                    }else{
                        Integer firstValue = high.get(firstKey);
                        if(firstValue==1){
                            high.remove(firstKey);
                        }else{
                            high.put(firstKey,firstValue-1);
                        }
                        high.put(num,high.getOrDefault(num,0)+1);
                        mid.put(firstKey,mid.getOrDefault(firstKey,0)+1);
                        size2++;
                        this.sum+=firstKey;
                    }
                }
            }else{
                Integer lastKey = low.lastKey();
                Integer lastValue = low.get(lastKey);
                if(lastValue==1){
                    low.remove(lastKey);
                }else{
                    low.put(lastKey,lastValue-1);
                }
                low.put(num,low.getOrDefault(num,0)+1);
                if(size3<k){
                    high.put(lastKey,high.getOrDefault(lastKey,0)+1);
                    size3++;
                }else{
                    mid.put(lastKey,mid.getOrDefault(lastKey,0)+1);
                    size2++;
                    this.sum+=lastKey;
                }
            }
        }
    }

    public int calculateMKAverage() {
        if(data.size()<m){
            return -1;
        }else {
            return sum/(m-2*k);
        }
    }
}
