package EveryDayExercise.PrefixCount;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int sum=0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].startsWith(pref)){
                sum++;
            }
        }
        return sum;
    }
}
