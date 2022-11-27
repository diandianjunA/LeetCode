package EveryDayExercise.PartitionDisjoint;

import org.junit.Test;

public class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] info = new int[nums.length];
        int min=Integer.MAX_VALUE;
        for (int i = nums.length-1; i >=0; i--) {
            if(nums[i]<min){
                min=nums[i];
            }
            info[i]=min;
        }
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(max<=info[i]){
                return i;
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return nums.length;
    }
    @Test
    public void test1(){
        int[] nums={5,0,3,8,6};
        System.out.println(partitionDisjoint(nums));
    }
    @Test
    public void test2(){
        int[] nums={1,1,1,0,6,12};
        System.out.println(partitionDisjoint(nums));
    }
    @Test
    public void test3(){
        int[] nums={1,1};
        System.out.println(partitionDisjoint(nums));
    }
}
class Solution2 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }
}