package EveryDayExercise.MinOperations;

import org.junit.Test;

public class Solution {
    public int minOperations(String s) {
        char[] c1 = new char[s.length()];
        char[] c2 = new char[s.length()];
        c1[0]='0';
        c2[0]='1';
        for (int i = 1; i < s.length(); i++) {
            c1[i]=c2[i-1];
            c2[i]=c1[i-1];
        }
        int res1=0;
        int res2=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=c1[i]){
                res1++;
            }
            if(s.charAt(i)!=c2[i]){
                res2++;
            }
        }
        return Math.min(res1,res2);
    }

    @Test
    public void test1(){
        String s="0100";
        System.out.println(minOperations(s));
    }

    @Test
    public void test2(){
        String s="10";
        System.out.println(minOperations(s));
    }

    @Test
    public void test3(){
        String s="1111";
        System.out.println(minOperations(s));
    }

    @Test
    public void test4(){
        String s="10010100";
        System.out.println(minOperations(s));
    }
}
