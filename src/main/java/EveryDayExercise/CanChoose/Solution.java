package EveryDayExercise.CanChoose;

import org.junit.Test;

public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int k=0;
        for (int i = 0; i < groups.length; i++) {
            k = findSubArray(groups[i],nums,k);
            if(k==-1){
                return false;
            }
        }
        return true;
    }

    public int findSubArray(int[] group,int[] nums,int i){
        int k=0;
        while (true){
            while(i<nums.length&&group[0]!=nums[i]){
                i++;
            }
            if(i>=nums.length){
                return -1;
            }
            int j=0;
            k=i;
            while(j<group.length&&i<nums.length&&group[j]==nums[i]){
                j++;
                i++;
            }
            if(j==group.length){
                return i;
            }else{
                i=k+1;
            }
        }
    }

    @Test
    public void test1(){
        int[][] groups = {{10, -2}, {1, 2, 3, 4}};
        int[] nums = {1, 2, 3, 4, 10, -2};
        System.out.println(canChoose(groups,nums));
    }

    @Test
    public void test2(){
        int[][] groups = {{1,2,3},{3,4}};
        int[] nums = {7,7,1,2,3,4,7,7};
        System.out.println(canChoose(groups,nums));
    }

    @Test
    public void test3(){
        int[][] groups = {{21, 22, 21, 22, 21, 30}};
        int[] nums = {21,22,21,22,21,22,21,30};
        System.out.println(canChoose(groups,nums));
    }
}
