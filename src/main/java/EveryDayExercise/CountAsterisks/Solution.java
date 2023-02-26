package EveryDayExercise.CountAsterisks;

import org.junit.Test;

public class Solution {
    public int countAsterisks(String s) {
        String[] split = s.split("\\|");
        int res=0;
        for (int i = 0; i < split.length; i++) {
            if(i%2==0){
                for (int j = 0; j < split[i].length(); j++) {
                    if(split[i].charAt(j)=='*'){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String s="l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
    }

    @Test
    public void test2(){
        String s="iamprogrammer";
        System.out.println(countAsterisks(s));
    }

    @Test
    public void test3(){
        String s="yo|uar|e**|b|e***au|tifu|l";
        System.out.println(countAsterisks(s));
    }
}
