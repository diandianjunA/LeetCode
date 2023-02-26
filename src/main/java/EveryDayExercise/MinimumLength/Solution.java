package EveryDayExercise.MinimumLength;

import org.junit.Test;

public class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j&&s.charAt(i)==s.charAt(j)){
            while(i<j&&s.charAt(i)==s.charAt(i+1)){
                i++;
            }
            i++;
            while(i<j&&s.charAt(j)==s.charAt(j-1)){
                j--;
            }
            j--;
        }
        if(i<=j){
            return j-i+1;
        }else{
            return 0;
        }
    }

    @Test
    public void test1(){
        String s="ca";
        System.out.println(minimumLength(s));
    }

    @Test
    public void test2(){
        String s="cabaabac";
        System.out.println(minimumLength(s));
    }

    @Test
    public void test3(){
        String s="aabccabba";
        System.out.println(minimumLength(s));
    }

    @Test
    public void test4(){
        String s="bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println(minimumLength(s));
    }
}
