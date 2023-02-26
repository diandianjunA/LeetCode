package EveryDayExercise.MaxScore;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int maxScore(int[] nums){
        int[] dp = new int[1 << nums.length];
        for (int i = 0; i < dp.length; i++) {
            int cnt = Integer.bitCount(i);
            if(cnt%2==0){
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                while(s.length()<nums.length){
                    s.insert(0, '0');
                }
                StringBuilder reverse = s.reverse();
                for (int j = 0; j < reverse.length(); j++) {
                    if(reverse.charAt(j)=='1'){
                        for (int k = j+1; k < reverse.length(); k++) {
                            if(reverse.charAt(k)=='1'){
                                dp[i]=Math.max(dp[i],dp[i^(1<<j)^(1<<k)]+cnt/2*gcd(nums[j],nums[k]));
                            }
                        }
                    }
                }
            }
        }
        return dp[(1<<nums.length)-1];
    }

    public int gcd(int a,int b){
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        int c=x%y;
        while(c!=0){
            x=y;
            y=c;
            c=x%y;
        }
        return y;
    }

    @Test
    public void test1(){
        int[] nums={1,2};
        System.out.println(maxScore(nums));
    }

    @Test
    public void test2(){
        int[] nums={3,4,6,8};
        System.out.println(maxScore(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3,4,5,6};
        System.out.println(maxScore(nums));
    }
}
