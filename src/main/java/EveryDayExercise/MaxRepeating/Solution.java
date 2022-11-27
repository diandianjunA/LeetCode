package EveryDayExercise.MaxRepeating;

import org.junit.Test;

public class Solution {
    public int maxRepeating(String sequence, String word) {
        int res=0;
        String primeWord=word;
        while (kmp(sequence,word)!=-1){
            res++;
            word=word+primeWord;
        }
        return res;
    }

    public int kmp(String str1,String str2){
        int[] next = kmpNext(str2);
        for (int i = 0,j=0; i < str1.length(); i++) {
            while (j>0&&str2.charAt(j)!=str1.charAt(i)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public int[] kmpNext(String str){
        int[] next = new int[str.length()];
        next[0]=0;
        int j=0;
        for (int i = 1; i < str.length(); i++) {
            while (j>0&&str.charAt(j)!=str.charAt(i)){
                j=next[j-1];
            }
            if(str.charAt(j)==str.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    @Test
    public void test1(){
        String sequence="aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word="aaaba";
        System.out.println(maxRepeating(sequence,word));
    }
}
