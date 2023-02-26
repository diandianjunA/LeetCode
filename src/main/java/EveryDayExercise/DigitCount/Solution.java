package EveryDayExercise.DigitCount;

import org.junit.Test;

public class Solution {
    public boolean digitCount(String num) {
        int[] temp = new int[10];
        for (int i = 0; i < num.length(); i++) {
            temp[num.charAt(i)-'0']++;
        }
        StringBuilder numBuilder = new StringBuilder(num);
        while(numBuilder.length()<10){
            numBuilder.append("0");
        }
        num = numBuilder.toString();
        for (int i = 0; i < temp.length; i++) {
            if(num.charAt(i)-'0'!=temp[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        System.out.println(digitCount("1210"));
    }
}
