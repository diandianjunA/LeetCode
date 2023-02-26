package EveryDayExercise.CalculateTax;

import org.junit.Test;

public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res=0;
        if(income<brackets[0][0]){
            return income*brackets[0][1]*0.01;
        }else {
            res=brackets[0][0]*brackets[0][1]*0.01;
        }
        for (int i = 1; i < brackets.length; i++) {
            if(income<brackets[i][0]){
                res+=(income-brackets[i-1][0])*brackets[i][1]*0.01;
                return res;
            }else{
                res+=(brackets[i][0]-brackets[i-1][0])*brackets[i][1]*0.01;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[][] brackets={{3,50},{7,10},{12,25}};
        int income=10;
        System.out.println(calculateTax(brackets,income));
    }

    @Test
    public void test2(){
        int[][] brackets={{1,0},{4,25},{5,50}};
        int income=2;
        System.out.println(calculateTax(brackets,income));
    }

    @Test
    public void test3(){
        int[][] brackets={{2,50}};
        int income=0;
        System.out.println(calculateTax(brackets,income));
    }
}
