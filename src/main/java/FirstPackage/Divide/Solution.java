package FirstPackage.Divide;

import org.junit.Test;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        long dividends=dividend;
        long divisors=divisor;
        if(divisor==1){
            return dividend;
        }
        if (divisor==-1){
            dividends=-dividends;
            if(dividends>0){
                return (int) Math.min(dividends,(1L<<31)-1);
            }else{
                return (int) Math.max(dividends,-(1L<<31));
            }
        }
        int index=0;
        if(dividend>0&&divisor>0||dividend<0&&divisor<0){
            index=1;
        }else {
            index=-1;
        }
        dividends=Math.abs(dividends);
        divisors=Math.abs(divisors);
        long res=1;
        long temp=divisors;
        while (temp<=dividends){
            temp+=divisors;
            res++;
        }
        if(index>0&&res-1>((1L <<31)-1)){
            return (int) ((1L <<31)-1);
        }
        if (index<0&&res-1>(1L <<31)){
            return (int) -(1L <<31);
        }
        return (int) (index*(res-1));
    }

    @Test
    public void test1(){
        int dividend=10;
        int divisor=3;
        System.out.println(divide(dividend,divisor));
    }

    @Test
    public void test2(){
        int dividend=7;
        int divisor=-3;
        System.out.println(divide(dividend,divisor));
    }

    @Test
    public void test3(){
        int dividend=1;
        int divisor=1;
        System.out.println(divide(dividend,divisor));
    }

    @Test
    public void test4(){
        int dividend=-2147483648;
        int divisor=-1;
        System.out.println(divide(dividend,divisor));
    }

    @Test
    public void test5(){
        int dividend=-2147483648;
        int divisor=1;
        System.out.println(divide(dividend,divisor));
    }

    @Test
    public void test6(){
        int dividend=1;
        int divisor=-1;
        System.out.println(divide(dividend,divisor));
    }

    @Test
    public void test7(){
        int dividend=-1010369383;
        int divisor=-2147483648;
        System.out.println(divide(dividend,divisor));
    }
}
