package EveryDayExercise.IsIdealPermutation;

import org.junit.Test;

public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int[] temp = new int[nums.length];
        temp[nums.length-1]=nums[nums.length-1];
        for (int i = nums.length-2; i >= 0 ; i--) {
            temp[i] = Math.min(nums[i], temp[i + 1]);
        }
        for (int i = 0; i+2 < nums.length; i++) {
            if(nums[i]>temp[i+2]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        int[] nums={1,0,2};
        System.out.println(isIdealPermutation(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,2,0};
        System.out.println(isIdealPermutation(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,0,3};
        System.out.println(isIdealPermutation(nums));
    }
}
class Solution2 {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minSuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }
}
class Solution3 {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}