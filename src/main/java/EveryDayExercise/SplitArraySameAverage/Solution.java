package EveryDayExercise.SplitArraySameAverage;

import org.junit.Test;

import java.util.HashSet;

public class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums.length*nums[i];
            sum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]-sum/nums.length;
        }
        int m=nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int total=0;
            for (int j = 0; j < m; j++) {
                if((i&(1<<j))!=0){
                    total+=nums[j];
                }
            }
            if(total==0){
                return true;
            }
            set.add(total);
        }
        for (int i = 1; i <(1<<(nums.length-m))-1; i++) {
            int total=0;
            for (int j = m; j < nums.length; j++) {
                if((i&(1<<(j-m)))!=0){
                    total+=nums[j];
                }
            }
            if(total==0||set.contains(-total)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        int[] nums={1,2,3,4,5,6,7,8};
        System.out.println(splitArraySameAverage(nums));
    }

    @Test
    public void test2(){
        int[] nums={3,1};
        System.out.println(splitArraySameAverage(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,6,1};
        System.out.println(splitArraySameAverage(nums));
    }

    @Test
    public void test4(){
        int[] nums={18,0,16,2};
        System.out.println(splitArraySameAverage(nums));
    }
}
