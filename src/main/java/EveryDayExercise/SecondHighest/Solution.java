package EveryDayExercise.SecondHighest;

import org.junit.Test;

public class Solution {
    public int secondHighest(String s) {
        int max=-1;
        int sub=-1;
        for (int i = 0; i < s.length(); i++) {
            int i1=-1;
            try {
                i1 = Integer.parseInt(s.charAt(i) + "");
            }catch (Exception e){
                continue;
            }
            if(i1>max){
                sub=max;
                max=i1;
            }else if(i1<max&&i1>sub){
                sub=i1;
            }
        }
        return sub;
    }

    @Test
    public void test1(){
        String s="sjhtz8344";
        System.out.println(secondHighest(s));
    }
}
