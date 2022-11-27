package EveryDayExercise.HalvesAreAlike;

import java.util.ArrayList;

public class Solution {
    public boolean halvesAreAlike(String s) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        int res1=0;
        int res2=0;
        for (int i = 0; i < s.length()/2; i++) {
            if(list.contains(s.charAt(i))){
                res1++;
            }
            if(list.contains(s.charAt(i+s.length()/2))){
                res2++;
            }
        }
        return res1==res2;
    }
}
