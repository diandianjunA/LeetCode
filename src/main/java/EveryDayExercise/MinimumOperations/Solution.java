package EveryDayExercise.MinimumOperations;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int pre=0;
        for (int num : nums) {
            if (num - pre > 0) {
                pre = num;
                res++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={1,5,0,3,5};
        System.out.println(minimumOperations(nums));
    }

    @Test
    public void test2(){
        int[] nums={0};
        System.out.println(minimumOperations(nums));
    }
}
