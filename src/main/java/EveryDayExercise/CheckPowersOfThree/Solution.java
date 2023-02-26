package EveryDayExercise.CheckPowersOfThree;

import org.junit.Test;

public class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            if(n%3==0){
                n=n/3;
            }else{
                n=n-1;
                if(n%3==0){
                    n=n/3;
                }else{
                    return false;
                }
            }
        }
        return n == 0;
    }

    @Test
    public void test1(){
        int n=12;
        System.out.println(checkPowersOfThree(n));
    }

    @Test
    public void test2(){
        int n=91;
        System.out.println(checkPowersOfThree(n));
    }

    @Test
    public void test3(){
        int n=21;
        System.out.println(checkPowersOfThree(n));
    }
}
