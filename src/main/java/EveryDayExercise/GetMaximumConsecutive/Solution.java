package EveryDayExercise.GetMaximumConsecutive;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res=0;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i]<=res+1){
                res=res+coins[i];
            }else{
                return res+1;
            }
        }
        return res+1;
    }

    @Test
    public void test1(){
        int[] coins={1,3};
        System.out.println(getMaximumConsecutive(coins));
    }

    @Test
    public void test2(){
        int[] coins={1,1,1,4};
        System.out.println(getMaximumConsecutive(coins));
    }

    @Test
    public void test3(){
        int[] coins={1,4,10,3,1};
        System.out.println(getMaximumConsecutive(coins));
    }
}
