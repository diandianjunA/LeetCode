package EveryDayExercise.StoneGame;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public boolean stoneGame(int[] piles) {
        int[] s=new int[piles.length+1];
        s[0]=0;
        for (int i = 1; i < piles.length+1; i++) {
            s[i]=s[i-1]+piles[i-1];
        }
        int[][] cache = new int[piles.length + 1][piles.length + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i],-1);
        }
        int mark = play(piles,s,cache, 1, piles.length);
        return mark>s[piles.length]-s[0]-mark;
    }

    public int play(int[] piles, int[] s, int[][] cache, int begin, int end){
        if(cache[begin][end]!=-1){
            return cache[begin][end];
        }
        if(begin==end){
            return piles[begin-1];
        }
        int chooseBegin=s[end]-s[begin]-play(piles,s, cache, begin+1,end)+piles[begin-1];
        int chooseEnd=s[end-1]-s[begin-1]-play(piles,s, cache, begin,end-1)+piles[end-1];
        return cache[begin][end]=Math.max(chooseBegin,chooseEnd);
    }

    @Test
    public void test1(){
        int[] pile={5,3,4,5};
        System.out.println(stoneGame(pile));
    }

    @Test
    public void test2(){
        int[] pile={3,7,2,3};
        System.out.println(stoneGame(pile));
    }
}
