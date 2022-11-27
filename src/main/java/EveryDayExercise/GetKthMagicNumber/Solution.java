package EveryDayExercise.GetKthMagicNumber;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[1]=1;
        int point3=1,point5=1,point7=1;
        for (int i =2; i <= k; i++) {
            dp[i]=Math.min(dp[point3]*3,Math.min(dp[point7]*7,dp[point5]*5));
            if(dp[i]==dp[point3]*3){
                point3++;
            }
            if(dp[i]==dp[point5]*5){
                point5++;
            }
            if(dp[i]==dp[point7]*7){
                point7++;
            }
        }
        return dp[k];
    }

    @Test
    public void test(){
        int k=643;
        System.out.println(getKthMagicNumber(k));
    }
}
