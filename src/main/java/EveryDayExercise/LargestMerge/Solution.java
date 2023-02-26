package EveryDayExercise.LargestMerge;

import org.junit.Test;

public class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i=0;
        int j=0;
        while(i<word1.length()&&j<word2.length()){
            if(word1.charAt(i)>word2.charAt(j)){
                res.append(word1.charAt(i++));
            } else if (word1.charAt(i)<word2.charAt(j)) {
                res.append(word2.charAt(j++));
            }else {
                res.append(word1.charAt(i));
                int k=1;
                while(i+k<word1.length()&&j+k<word2.length()&&word1.charAt(i+k)==word2.charAt(j+k)){
                    k++;
                }
                if(i+k>=word1.length()){
                    j++;
                    continue;
                } else if (j + k >= word2.length()) {
                    i++;
                    continue;
                }
                if(word1.charAt(i+k)>word2.charAt(j+k)){
                    i++;
                }else{
                    j++;
                }
            }
        }
        if(i>=word1.length()){
            while(j<word2.length()){
                res.append(word2.charAt(j++));
            }
        }else{
            while(i<word1.length()){
                res.append(word1.charAt(i++));
            }
        }
        return res.toString();
    }

    @Test
    public void test1(){
        String word1="cabaa";
        String word2="bcaaa";
        System.out.println(largestMerge(word1,word2));
    }

    @Test
    public void test2(){
        String word1="abcabc";
        String word2="abdcaba";
        System.out.println(largestMerge(word1,word2));
    }

    @Test
    public void test3(){
        String word1="guguuuuuuuuuuuuuuguguuuuguug";
        String word2="gguggggggguuggguugggggg";
        System.out.println(largestMerge(word1,word2));
    }
}
