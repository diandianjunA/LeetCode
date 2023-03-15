package EveryDayExercise.PrintBin;

import org.junit.Test;

import java.math.BigDecimal;

public class Solution {
    public String printBin(double num){
        BigDecimal bigDecimal = new BigDecimal(num);
        StringBuilder res = new StringBuilder("0.");
        while (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
            bigDecimal = bigDecimal.multiply(new BigDecimal(2));
            if (bigDecimal.compareTo(BigDecimal.ONE) >= 0) {
                res.append(1);
                bigDecimal = bigDecimal.subtract(BigDecimal.ONE);
            } else {
                res.append(0);
            }
            if (res.length() > 32) {
                return "ERROR";
            }
        }
        return res.toString();
    }
    @Test
    public void test1(){
        double num=0.625;
        System.out.println(printBin(num));
    }

    @Test
    public void test2(){
        double num=0.1;
        System.out.println(printBin(num));
    }
}

