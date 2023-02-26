package EveryDayExercise.NumberOfPairs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]==nums[i+1]){
                i++;
            }else{
                res.add(nums[i]);
            }
        }
        int[] rest = new int[2];
        rest[0]=(nums.length-res.size())/2;
        rest[1]=res.size();
        if(rest[0]*2+rest[1]!=nums.length){
            rest[1]++;
        }
        return rest;
    }

    @Test
    public void test1(){
        int[] nums={1,3,2,1,3,2,2};
        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }

    @Test
    public void test2(){
        int[] nums={1,1};
        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }

    @Test
    public void test3(){
        int[] nums={0};
        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }
}
