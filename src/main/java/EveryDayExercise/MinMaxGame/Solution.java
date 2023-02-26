package EveryDayExercise.MinMaxGame;

import org.junit.Test;

public class Solution {
    public int minMaxGame(int[] nums) {
        int[] newNums = new int[nums.length];
        int length=nums.length/2;
        while(length>0){
            for (int i = 0; i < length; i++) {
                if(i%2==0){
                    newNums[i]=Math.min(nums[2*i],nums[2*i+1]);
                }else{
                    newNums[i]=Math.max(nums[2*i],nums[2*i+1]);
                }
            }
            int[] temp=nums;
            nums=newNums;
            newNums=temp;
            length=length/2;
        }
        return nums[0];
    }

    @Test
    public void test1(){
        int[] nums={93,40};
        System.out.println(minMaxGame(nums));
    }
}
