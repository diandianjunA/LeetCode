package EveryDayExercise.MinimumSwap;

import org.junit.Test;

public class Solution {
    public int minimumSwap(String s1, String s2) {
        int x1=0;
        int x2=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='x'){
                    x1++;
                }else {
                    x2++;
                }
            }
        }
        int res=x1/2+x2/2;
        x1=x1%2;
        x2=x2%2;
        if ((x1+x2)%2==0){
            return res+(x1+x2);
        }else {
            return -1;
        }
    }

    @Test
    public void test1(){
        String s1="xx";
        String s2="yy";
        System.out.println(minimumSwap(s1,s2));
    }

    @Test
    public void test2(){
        String s1="xy";
        String s2="yx";
        System.out.println(minimumSwap(s1,s2));
    }

    @Test
    public void test3(){
        String s1="xx";
        String s2="xy";
        System.out.println(minimumSwap(s1,s2));
    }

    @Test
    public void test4(){
        String s1="xxyyxyxyxx";
        String s2="xyyxyxxxyx";
        System.out.println(minimumSwap(s1,s2));
    }
}
