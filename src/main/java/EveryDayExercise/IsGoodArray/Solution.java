package EveryDayExercise.IsGoodArray;

import org.junit.Test;

public class Solution {
    public boolean isGoodArray(int[] nums) {
        if(nums.length==1){
            return nums[0] == 1;
        }
        int t=nums[0];
        for (int i = 1; i < nums.length; i++) {
            t=gcd(t,nums[i]);
            if(t==1){
                return true;
            }
        }
        return false;
    }

    public int gcd(int a,int b){
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        int t=x%y;
        while (t!=0){
            x=y;
            y=t;
            t=x%y;
        }
        return y;
    }

    @Test
    public void test1(){
        int[] nums={12,5,7,23};
        System.out.println(isGoodArray(nums));
    }

    @Test
    public void test2(){
        int[] nums={29,6,10};
        System.out.println(isGoodArray(nums));
    }

    @Test
    public void test3(){
        int[] nums={3,6};
        System.out.println(isGoodArray(nums));
    }

    @Test
    public void test4(){
        int[] nums={6,10,15};
        System.out.println(isGoodArray(nums));
    }
}
