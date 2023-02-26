package EveryDayExercise.BeautySum;

import org.junit.Test;

public class Solution {
    public int beautySum(String s) {
        int sum=0;
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i+2; j < s.length(); j++) {
                sum+=sum(s,i,j);
            }
        }
        return sum;
    }
    public int sum(String s,int i,int j){
        int[] info = new int[26];
        for (int k = i; k <= j; k++) {
            info[s.charAt(k)-'a']++;
        }
        int max=0;
        int maxNum=0;
        int min=Integer.MAX_VALUE;
        int minNum=0;
        for (int k = 0; k < 26; k++) {
            if(info[k]>max&&info[k]!=0){
                max=info[k];
                maxNum=k;
            }
            if(info[k]<min&&info[k]!=0){
                min=info[k];
                minNum=k;
            }
        }
        return max-min;
    }

    @Test
    public void test1(){
        String s="aabcb";
        System.out.println(beautySum(s));
    }

    @Test
    public void test2(){
        String s="aabcbaa";
        System.out.println(beautySum(s));
    }
}
