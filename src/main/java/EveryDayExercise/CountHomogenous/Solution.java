package EveryDayExercise.CountHomogenous;

import org.junit.Test;

public class Solution {
    public int countHomogenous(String s) {
        long sum=0;
        int mod=1000000007;
        for (int i = 0; i < s.length(); i++) {
            int length=1;
            while(i+1<s.length()&&s.charAt(i+1)==s.charAt(i)){
                length++;
                i++;
            }
            sum=(sum+sum(length))%mod;
        }
        return (int) sum;
    }

    public long sum(int value){
        return (long) (value + 1) *value/2;
    }

    @Test
    public void test1(){
        String s="abbcccaa";
        System.out.println(countHomogenous(s));
    }

    @Test
    public void test2(){
        String s="xy";
        System.out.println(countHomogenous(s));
    }

    @Test
    public void test3(){
        String s="zzzzz";
        System.out.println(countHomogenous(s));
    }
}
