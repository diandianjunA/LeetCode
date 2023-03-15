package EveryDayExercise.CountTriplets;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int countTriplets(int[] nums) {
        int[] cache = new int[1 << 16];
        Arrays.fill(cache,-1);
        int res=0;
        for (int num : nums) {
            for (int i : nums) {
                int key = num & i;
                if (cache[key] != -1) {
                    res += cache[key];
                } else {
                    int temp = 0;
                    for (int j : nums) {
                        if ((key & j) == 0) {
                            temp++;
                        }
                    }
                    cache[key] = temp;
                    res += temp;
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={2,1,3};
        System.out.println(countTriplets(nums));
    }

    @Test
    public void test2(){
        int[] nums={0,0,0};
        System.out.println(countTriplets(nums));
    }
}
