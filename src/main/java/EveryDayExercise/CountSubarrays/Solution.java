package EveryDayExercise.CountSubarrays;

import org.junit.Test;

import java.util.HashMap;

/**
 * 超时
 */
public class Solution {
    public int countSubarrays(int[] nums, int k) {
        int loc=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==k){
                loc=i;
                break;
            }
        }
        int res=1;
        int gap=0;
        int preGap=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = loc+1; j < nums.length; j++) {
            if(nums[j]<nums[loc]){
                gap++;
            }else{
                gap--;
            }
            if(gap==0||gap==-1){
                res++;
            }
            map.put(gap,map.getOrDefault(gap,0)+1);
        }
        gap=0;
        for (int i = loc-1; i >= 0 ; i--) {
            if(nums[i]<nums[loc]){
                gap++;
            }else{
                gap--;
            }
            if(gap==0||gap==-1){
                res++;
            }
            res+=map.getOrDefault(-gap,0);
            res+=map.getOrDefault(-gap-1,0);
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={3,2,1,4,5};
        int k=4;
        System.out.println(countSubarrays(nums,k));
    }

    @Test
    public void test2(){
        int[] nums={2,3,1};
        int k=3;
        System.out.println(countSubarrays(nums,k));
    }
}
