package EveryDayExercise.CircularPermutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int[] res;
    boolean[] used;
    public List<Integer> circularPermutation(int n, int start) {
        used=new boolean[1<<n];
        res=new int[1<<n];
        used[start]=true;
        res[0]=start;
        get(1,start,n);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            list.add(res[i]);
        }
        return list;
    }

    public boolean get(int bit,int num,int n){
        int i=1;
        int p=0;
        if(bit==((1<<n)-1)){
            for (int j = 0; j < n; j++) {
                i=(1<<j);
                p=num^i;
                if(!used[p]){
                    int integer = res[0];
                    int bitCount = Integer.bitCount(p ^ integer);
                    if(bitCount==1){
                        res[bit]=p;
                        used[p]=true;
                        return true;
                    }
                }
            }
        }else{
            for (int j = 0; j < n; j++) {
                i=(1<<j);
                p=num^i;
                if(!used[p]){
                    used[p]=true;
                    if(get(bit+1,p,n)){
                        res[bit]=p;
                        return true;
                    }else{
                        used[p]=false;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void test1(){
        int n=2;
        int start=3;
        System.out.println(circularPermutation(n,start));
    }

    @Test
    public void test2(){
        int n=3;
        int start=2;
        System.out.println(circularPermutation(n,start));
    }
}
