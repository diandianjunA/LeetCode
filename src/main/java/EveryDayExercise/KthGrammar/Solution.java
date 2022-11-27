package EveryDayExercise.KthGrammar;

import org.junit.Test;

public class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }
        int num = kthGrammar(n - 1, (k + 1) / 2);
        if(num==0){
            if(k%2!=0){
                return 0;
            }else {
                return 1;
            }
        }else{
            if(k%2!=0){
                return 1;
            }else {
                return 0;
            }
        }
    }
    @Test
    public void test1(){
        int n=1;
        int k=1;
        System.out.println(kthGrammar(n,k));
    }
    @Test
    public void test2(){
        int n=2;
        int k=1;
        System.out.println(kthGrammar(n,k));
    }
    @Test
    public void test3(){
        int n=2;
        int k=2;
        System.out.println(kthGrammar(n,k));
    }
}
class Solution2 {
    public int kthGrammar(int n, int k) {
        // return Integer.bitCount(k - 1) & 1;
        k--;
        int res = 0;
        while (k > 0) {
            k &= k - 1;
            res ^= 1;
        }
        return res;
    }
}