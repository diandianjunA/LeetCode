package EveryDayExercise.MinTaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<Integer>[] lists = new PriorityQueue[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i]= new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -(o1+ranges[o1]-o2-ranges[o2]);
                }
            });
        }
        for (int i = 0; i < ranges.length; i++) {
            for (int j = Math.max(i-ranges[i],0); j <= Math.min(i+ranges[i],n); j++) {
                lists[j].add(i);
            }
        }
        int i=0;
        int res=0;
        while (true){
            if(i!=n&&lists[i].isEmpty()){
                return -1;
            }else {
                Integer poll = lists[i].poll();
                i=poll+ranges[poll];
                res++;
            }
            if(i>=n){
                break;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int n=5;
        int[] ranges={3,4,1,1,0,0};
        System.out.println(minTaps(n,ranges));
    }

    @Test
    public void test2(){
        int n=3;
        int[] ranges={0,0,0,0};
        System.out.println(minTaps(n,ranges));
    }
}
