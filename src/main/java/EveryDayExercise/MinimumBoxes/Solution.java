package EveryDayExercise.MinimumBoxes;

import org.junit.Test;

public class Solution {
    public int minimumBoxes(int n) {
        int layer1 = getLayer1(n);
        int extra=n-exp1(layer1-1);
        int layer2 = getLayer2(extra);
        if(layer2>=layer1){
            return layer1+exp2(layer1-1);
        }else{
            return layer2+exp2(layer1-1);
        }
    }

    public int getLayer1(int n){
        int i=1;
        while(exp1(i)<n){
            i++;
        }
        return i;
    }

    public int getLayer2(int n){
        int i=1;
        while(exp2(i)<n){
            i++;
        }
        return i;
    }

    public int exp1(int i){
        double[] param={1.0/6,1.0/2,1.0/3,0};
        double res=0;
        for (double v : param) {
            res = v + res * i;
        }
        return (int) Math.round(res);
    }

    public int exp2(int i){
        double[] param={1.0/2,1.0/2,0};
        double res=0;
        for (double v : param) {
            res = v + res * i;
        }
        return (int) Math.round(res);
    }

    @Test
    public void test1(){
        int n=3;
        System.out.println(minimumBoxes(n));
    }

    @Test
    public void test2(){
        int n=4;
        System.out.println(minimumBoxes(n));
    }

    @Test
    public void test3(){
        int n=10;
        System.out.println(minimumBoxes(n));
    }

    @Test
    public void test4(){
        int n=15;
        System.out.println(minimumBoxes(n));
    }

    @Test
    public void test5(){
        int n=126;
        System.out.println(minimumBoxes(n));
    }

    @Test
    public void testExp1(){
        int i=8;
        System.out.println(exp1(i));
    }

    @Test
    public void testExp2(){
        int i=0;
        System.out.println(exp2(i));
    }
}
