package EveryDayExercise.NthMagicalNumber;

import org.junit.Test;

public class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod=1000000007;
        int c=Math.max(a,b);
        int d=Math.min(a,b);
        if(c%d==0){
            return d*n;
        }
        int t=c%d;
        while (t!=0){
            c=d;
            d=t;
            t=c%d;
        }
        int f= a *b/d;
        long l=Math.min(a,b);
        long r= (long) n *Math.min(a,b);
        while(l<r){
            long mid=(l+r)/2;
            long i = mid / a + mid / b - mid / f;
            if(i ==n){
                return (int) (mid%mod);
            }else if (i >n){
                r=r-1;
            }else{
                l=l+1;
            }
        }
        return (int) (r%mod);
    }
    @Test
    public void test1(){
        int n=1;
        int a=2;
        int b=3;
        System.out.println(nthMagicalNumber(n,a,b));
    }

    @Test
    public void test2(){
        int n=4;
        int a=2;
        int b=3;
        System.out.println(nthMagicalNumber(n,a,b));
    }
}
