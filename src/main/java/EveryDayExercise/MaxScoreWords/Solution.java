package EveryDayExercise.MaxScoreWords;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] list=new int [26];
        for (int i = 0; i < letters.length; i++) {
            list[letters[i]-'a']++;
        }
        int[] strScore = new int[words.length];
        int[][] lists = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                strScore[i]+=score[words[i].charAt(j)-'a'];
                lists[i][words[i].charAt(j)-'a']++;
            }
        }
        return cal(lists,0,list,strScore);
    }

    public int cal(int[][] lists,int i,int[] letter,int[] score){
        if(i>=lists.length){
            return 0;
        }
        int pre=cal(lists, i+1, letter, score);
        boolean canGet=true;
        for (int j = 0; j < 26; j++) {
            if(letter[j]<lists[i][j]){
                canGet=false;
                break;
            }
        }
        if(!canGet){
            return pre;
        }else{
            for (int j = 0; j < 26; j++) {
                letter[j]-=lists[i][j];
            }
            int get = score[i] + cal(lists, i + 1, letter, score);
            for (int j = 0; j < 26; j++) {
                letter[j]+=lists[i][j];
            }
            return Math.max(pre, get);
        }
    }

    @Test
    public void test1(){
        String[] words={"dog","cat","dad","good"};
        char[] letters={'a','a','c','d','d','d','g','o','o'};
        int[] score={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words,letters,score));
    }

    @Test
    public void test2(){
        String[] words={"xxxz","ax","bx","cx"};
        char[] letters={'z','a','b','c','x','x','x'};
        int[] score={4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        System.out.println(maxScoreWords(words,letters,score));
    }

    @Test
    public void test3(){
        String[] words={"leetcode"};
        char[] letters={'l','e','t','c','o','d'};
        int[] score={0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words,letters,score));
    }
}
