package EveryDayExercise.FillCups;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res=0;
        while(true){
            if(amount[1]!=0){
                amount[2]--;
                amount[1]--;
            }else {
                return res+amount[2];
            }
            res++;
            Arrays.sort(amount);
        }
    }

    @Test
    public void test1(){
        int[] amount={1,4,2};
        System.out.println(fillCups(amount));
    }

    @Test
    public void test2(){
        int[] amount={5,4,4};
        System.out.println(fillCups(amount));
    }

    @Test
    public void test3(){
        int[] amount={5,0,0};
        System.out.println(fillCups(amount));
    }
}
