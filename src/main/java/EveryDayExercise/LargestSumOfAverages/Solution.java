package EveryDayExercise.LargestSumOfAverages;

import org.junit.Test;

public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length][k+1];
        int[] sum=new int[nums.length];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        sum[0]=nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=0;
            sum[i]=sum[i-1]+nums[i];
            dp[i][1]=(dp[i-1][1]*i+nums[i])/(i+1);
            for (int j = 2; j < Math.min(k+1,i+2); j++) {
                for (int l = 1; l < i+1; l++) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-l][j-1]+(sum[i]-sum[i-l])*1.0/l);
                }
            }
        }
        return dp[nums.length-1][k];
    }

    @Test
    public void test1(){
        int[] nums={9,1,2,3,9};
        int k=3;
        System.out.println(largestSumOfAverages(nums,k));
    }

    @Test
    public void test2(){
        int[] nums={1,2,3,4,5,6,7};
        int k=4;
        System.out.println(largestSumOfAverages(nums,k));
    }
}
