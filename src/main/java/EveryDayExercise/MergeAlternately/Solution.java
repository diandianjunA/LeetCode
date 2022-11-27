package EveryDayExercise.MergeAlternately;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i=0,j=0;
        while (i<word1.length()&&j<word2.length()){
            res.append(word1.charAt(i));
            res.append(word2.charAt(j));
            i++;
            j++;
        }
        if(i==word1.length()){
            if(j!=word2.length()){
                while (j<word2.length()){
                    res.append(word2.charAt(j));
                    j++;
                }
            }
        }else{
            while (i<word1.length()){
                res.append(word1.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
}
