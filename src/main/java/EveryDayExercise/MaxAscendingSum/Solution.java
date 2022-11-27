package EveryDayExercise.MaxAscendingSum;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum=0;
        int sum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
            }else{
                if(maxSum<sum){
                    maxSum=sum;
                }
                sum=nums[i];
            }
        }
        if(maxSum<sum){
            maxSum=sum;
        }
        return maxSum;
    }
    @Test
    public void test(){
        int[] nums={10,20,30,5,10,50};
        System.out.println(maxAscendingSum(nums));
    }
}
