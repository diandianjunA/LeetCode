package EveryDayExercise.StoneGameII;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int stoneGameII(int[] piles) {
        int[] s = new int[piles.length];
        s[piles.length-1]=piles[piles.length-1];
        for (int i = piles.length-2; i >= 0; i--) {
            s[i]=s[i+1]+piles[i];
        }
        int[][] cache=new int[s.length][2*s.length];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i],-1);
        }
        return dfs(piles,s,0,1,cache);
    }

    public int dfs(int[] pile, int[] s, int i, int M, int[][] cache){
        if(cache[i][M]!=-1){
            return cache[i][M];
        }
        if(i+2*M>=s.length){
            return s[i];
        }
        int res=0;
        for (int j = 1; j <= 2*M; j++) {
            res=Math.max(res,s[i]-dfs(pile, s, i+j, Math.max(M,j), cache));
        }
        return cache[i][M]=res;
    }

    @Test
    public void test1(){
        int[] piles={2,7,9,4,4};
        System.out.println(stoneGameII(piles));
    }

    @Test
    public void test2(){
        int[] piles={1,2,3,4,5,100};
        System.out.println(stoneGameII(piles));
    }
}
