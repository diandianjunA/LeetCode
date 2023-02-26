package EveryDayExercise.GrowMinOperations;

import org.junit.Test;

public class Solution {
    public int minOperations(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                continue;
            }
            res=res+nums[i-1]-nums[i]+1;
            nums[i]=nums[i-1]+1;
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={1,1,1};
        System.out.println(minOperations(nums));
    }
}
