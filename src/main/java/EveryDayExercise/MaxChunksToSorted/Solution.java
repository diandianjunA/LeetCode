package EveryDayExercise.MaxChunksToSorted;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int res=0;
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==list.get(0)){
                if(list.size()>=2){
                    if(max<=list.get(1)){
                        res++;
                    }
                }else {
                    res++;
                }
            } else if (max < arr[i]) {
                max=arr[i];
            }
            list.remove((Integer) arr[i]);
        }
        return res;
    }
    @Test
    public void test1(){
        int[] arr={4,3,2,1,0};
        System.out.println(maxChunksToSorted(arr));
    }
    @Test
    public void test2(){
        int[] arr={1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }
    @Test
    public void test3(){
        int[] arr={2,0,1};
        System.out.println(maxChunksToSorted(arr));
    }
    @Test
    public void test4(){
        int[] arr={1,2,0,3};
        System.out.println(maxChunksToSorted(arr));
    }
}
class Solution2 {
    public int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }
}