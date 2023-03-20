package EveryDayExercise.NumDupDigitsAtMostN;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int numDupDigitsAtMostN(int n) {
        String s=n+"";
        int[][] cache = new int[1<<10][s.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i],-1);
        }
        int high = s.charAt(0)-'0';
        int res=0;
        for (int i = 0; i <= high; i++) {
            if(i==0){
                res+=dp(s, 1, i==high, true, cache,0);
            }else{
                res+=dp(s, 1, i==high, false, cache,(1<<i));
            }
        }
        return res;
    }

    public int dp(String n, int bit, boolean limit,boolean allZero, int[][] cache,int mask){
        if(bit==n.length()){
            return 0;
        }
        if(!limit&&cache[mask][bit]!=-1){
            return cache[mask][bit];
        }
        int high= (limit)? n.charAt(bit)-'0' :9;
        int res=0;
        for (int i = 0; i <= high; i++) {
            if(allZero&&i==0){
                res+=dp(n, bit+1, limit&&i==high, true, cache,0);
            }else{
                if((mask&(1<<i))!=0){
                    if(limit&&i==high){
                        if(n.substring(bit + 1).equals("")){
                            res+=0;
                        }else{
                            res+=Integer.parseInt(n.substring(bit + 1));
                        }
                        res++;
                    }else{
                        res+=Math.pow(10,n.length()-1-bit);
                    }
                }else{
                    res+=dp(n, bit+1, limit&&i==high, false, cache,(mask|(1<<i)));
                }
            }
        }
        return cache[mask][bit]=res;
    }

    @Test
    public void test1(){
        int n=20;
        System.out.println(numDupDigitsAtMostN(n));
    }

    @Test
    public void test2(){
        int n=100;
        System.out.println(numDupDigitsAtMostN(n));
    }

    @Test
    public void test3(){
        int n=1000;
        System.out.println(numDupDigitsAtMostN(n));
    }
}
