package EveryDayExercise.StoneGameIII;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] s = new int[stoneValue.length];
        s[0]=stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            s[i]=s[i-1]+stoneValue[i];
        }
        int[] cache = new int[s.length];
        Arrays.fill(cache,-1);
        int mark = mark(stoneValue, s,cache, 0);
        if(mark>s[s.length-1]-mark){
            return "Alice";
        }else if(mark==s[s.length-1]-mark){
            return "Tie";
        }else {
            return "Bob";
        }
    }

    public int mark(int[] stoneValue, int[] s, int[] cache, int loc){
        if(loc==s.length){
            return 0;
        }
        if(cache[loc]!=-1){
            return cache[loc];
        }
        int res=-Integer.MAX_VALUE;
        int add=0;
        for (int i = 0; (i < 3)&&(loc+i<s.length); i++) {
            add+=stoneValue[loc+i];
            res=Math.max(res,s[s.length-1]-s[loc+i]-mark(stoneValue,s, cache, loc+i+1)+add);
        }
        return cache[loc]=res;
    }

    @Test
    public void test1(){
        int[] stoneValue={1,2,3,7};
        System.out.println(stoneGameIII(stoneValue));
    }

    @Test
    public void test2(){
        int[] stoneValue={1,2,3,-9};
        System.out.println(stoneGameIII(stoneValue));
    }

    @Test
    public void test3(){
        int[] stoneValue={1,2,3,6};
        System.out.println(stoneGameIII(stoneValue));
    }

    @Test
    public void test4(){
        int[] stoneValue={1,2,3,-1,-2,-3,7};
        System.out.println(stoneGameIII(stoneValue));
    }

    @Test
    public void test5(){
        int[] stoneValue={-1,-2,-3};
        System.out.println(stoneGameIII(stoneValue));
    }
}
