package EveryDayExercise.RepeatedCharacter;

import java.util.Arrays;

public class Solution {
    public char repeatedCharacter(String s) {
        int[] c = new int[26];
        Arrays.fill(c,-1);
        for (int i = 0; i < s.length(); i++) {
            if(c[s.charAt(i)-'a']==-1){
                c[s.charAt(i)-'a']=i;
            }else{
                return s.charAt(i);
            }
        }
        return 'a';
    }
}
