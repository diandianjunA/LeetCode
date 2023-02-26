package EveryDayExercise.IntToRoman;

import org.junit.Test;

public class Solution {
    public String intToRoman(int num) {
        int M=0;
        int D=0;
        int C=0;
        int L=0;
        int X=0;
        int V=0;
        int I=0;
        StringBuilder res = new StringBuilder();
        M=num/1000;
        while(M>0){
            res.append('M');
            M--;
        }
        num=num%1000;
        if(num>=900){
            res.append("CM");
            num=num-900;
        }
        D=num/500;
        while(D>0){
            res.append('D');
            D--;
        }
        num=num%500;
        if(num>=400){
            res.append("CD");
            num=num-400;
        }
        C=num/100;
        while(C>0){
            res.append('C');
            C--;
        }
        num=num%100;
        if(num>=90){
            res.append("XC");
            num=num-90;
        }
        L=num/50;
        while(L>0){
            res.append('L');
            L--;
        }
        num=num%50;
        if(num>=40){
            res.append("XL");
            num=num-40;
        }
        X=num/10;
        while(X>0){
            res.append('X');
            X--;
        }
        num=num%10;
        if(num == 9){
            res.append("IX");
            return res.toString();
        }
        V=num/5;
        while(V>0){
            res.append('V');
            V--;
        }
        num=num%5;
        if(num == 4){
            res.append("IV");
            return res.toString();
        }
        I=num;
        while(I>0){
            res.append('I');
            I--;
        }
        return res.toString();
    }

    @Test
    public void test1(){
        int num=3;
        System.out.println(intToRoman(num));
    }

    @Test
    public void test2(){
        int num=4;
        System.out.println(intToRoman(num));
    }

    @Test
    public void test3(){
        int num=9;
        System.out.println(intToRoman(num));
    }

    @Test
    public void test4(){
        int num=58;
        System.out.println(intToRoman(num));
    }

    @Test
    public void test5(){
        int num=1994;
        System.out.println(intToRoman(num));
    }
}
