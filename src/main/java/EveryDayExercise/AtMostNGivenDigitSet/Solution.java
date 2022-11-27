package EveryDayExercise.AtMostNGivenDigitSet;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int res=0;
        if(n<10){
            for (int i = 0; i < digits.length; i++) {
                if(Integer.parseInt(digits[i])<=n){
                    res++;
                }
            }
            return res;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            stringBuilder.append(digits[i]);
        }
        int[] f = new int[(n+"").length()];
        Arrays.fill(f,-1);
        f[f.length-1]=stringBuilder.length();
        for (int i = f.length-1; i >0; i--) {
            dfs(n+"",false,f,i,stringBuilder.toString());
        }
        res = dfs(n+"",true,f,0,stringBuilder.toString());
        for (int i = 1; i < f.length; i++) {
            res+=f[i];
        }
        return res;
    }
    public int dfs(String nums,boolean limit,int[] f,int digit,String digits){
        if(digit>=f.length){
            return 0;
        }
        int res=0;
        if(digit==f.length-1){
            if(limit){
                for (int i = 0; i <= nums.charAt(digit) - '0'; i++) {
                    if(digits.contains(i+"")){
                        res++;
                    }
                }
                return res;
            }else{
                return f[digit];
            }
        }
        if(!limit&&f[digit]!=-1){
            return f[digit];
        }
        int up=0;
        if(limit){
            up=nums.charAt(digit)-'0';
        }else{
            up=9;
        }
        for (int i = 0; i <= up; i++) {
            if(digits.contains(i+"")){
                res+=dfs(nums,limit&&(i==up),f,digit+1,digits);
            }
        }
        if(!limit){
            f[digit]=res;
        }
        return res;
    }
    @Test
    public void test1(){
        int n=100;
        String[] digits={"1","3","5","7"};
        System.out.println(atMostNGivenDigitSet(digits,n));
    }
    @Test
    public void test2(){
        int n=1000000000;
        String[] digits={"1","4","9"};
        System.out.println(atMostNGivenDigitSet(digits,n));
    }
    @Test
    public void test3(){
        int n=8;
        String[] digits={"7"};
        System.out.println(atMostNGivenDigitSet(digits,n));
    }
    @Test
    public void test4(){
        int n=4;
        String[] digits={"3","5"};
        System.out.println(atMostNGivenDigitSet(digits,n));
    }
    @Test
    public void test5(){
        int n=64;
        String[] digits={"3","4","5","6"};
        System.out.println(atMostNGivenDigitSet(digits,n));
    }
    @Test
    public void test6(){
        System.out.println(0.25*997.992*9.79338*0.971*(28.598+0.971/60));
    }
}
