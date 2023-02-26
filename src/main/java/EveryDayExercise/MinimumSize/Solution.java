package EveryDayExercise.MinimumSize;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int left=1;
        int right=max;
        while(left<=right){
            int mid=left+(right-left)/2;
            int op=0;
            for (int i = 0; i < nums.length; i++) {
                op=op+(nums[i]-1)/mid;
            }
            if(op<=maxOperations){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right+1;
    }

    @Test
    public void test1(){
        int[] nums={2,4,8,2};
        int maxOperations=4;
        System.out.println(minimumSize(nums,maxOperations));
    }

    @Test
    public void test2(){
        int[] nums={9};
        int maxOperations=2;
        System.out.println(minimumSize(nums,maxOperations));
    }

    @Test
    public void test3(){
        int[] nums={7,17};
        int maxOperations=2;
        System.out.println(minimumSize(nums,maxOperations));
    }

    @Test
    public void test4(){
        int[] nums={431,922,158,60,192,14,788,146,788,775,772,792,68,143,376,375,877,516,595,82,56,704,160,403,713,504,67,332,26};
        int maxOperations=80;
        System.out.println(minimumSize(nums,maxOperations));
    }
}
