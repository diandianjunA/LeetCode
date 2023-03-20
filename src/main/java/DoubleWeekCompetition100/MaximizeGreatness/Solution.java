package DoubleWeekCompetition100.MaximizeGreatness;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        for (; i < nums.length; i++) {
            while (j<nums.length&&nums[j]<=nums[i]){
                j++;
            }
            if(j==nums.length){
                return i;
            }
            j++;
        }
        return i;
    }

    @Test
    public void test1(){
        int[] nums={1,3,5,2,1,3,1};
        System.out.println(maximizeGreatness(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,2,3,4};
        System.out.println(maximizeGreatness(nums));
    }
}
