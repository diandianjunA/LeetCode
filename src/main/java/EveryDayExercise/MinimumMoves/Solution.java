package EveryDayExercise.MinimumMoves;

import org.junit.Test;

public class Solution {
    public int minimumMoves(String s) {
        int res=0;
        for (int i = 0; i < s.length(); i=i+3) {
            while(i<s.length()&&s.charAt(i)!='X'){
                i++;
            }
            if(i<s.length()){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String s="XXX";
        System.out.println(minimumMoves(s));
    }
}
