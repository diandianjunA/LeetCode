package EveryDayExercise.Check;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public boolean check(int[] nums) {
        int min=Integer.MAX_VALUE;
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(min>nums[i]){
                min=nums[i];
                pos.clear();
                pos.add(i);
            } else if (min == nums[i]) {
                pos.add(i);
            }
        }
        for (Integer posi : pos) {
            boolean flag=true;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[(posi+i)%nums.length]>nums[(posi+i+1)%nums.length]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        int[] nums={3,4,5,1,2};
        System.out.println(check(nums));
    }

    @Test
    public void test2(){
        int[] nums={2,1,3,4};
        System.out.println(check(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3};
        System.out.println(check(nums));
    }

    @Test
    public void test4(){
        int[] nums={6,10,6};
        System.out.println(check(nums));
    }
}
