package EveryDayExercise.ThreeSumClosest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }else if(sum>target){
                    k--;
                }else {
                    j++;
                }
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }

    @Test
    public void test2(){
        int[] nums={0,0,0};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }
}
