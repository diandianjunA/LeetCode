package EveryDayExercise.StrongPasswordCheckerII;

import org.junit.Test;

public class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8){
            return false;
        }else{
            boolean low=false;
            boolean high=false;
            boolean num=false;
            boolean special=false;
            if(password.charAt(0)>='a'&&password.charAt(0)<='z'){
                low=true;
            } else if (password.charAt(0) >= 'A' && password.charAt(0) <= 'Z') {
                high=true;
            } else if (password.charAt(0) >= '0' && password.charAt(0) <= '9') {
                num=true;
            } else{
                special=true;
            }
            for (int i = 1; i < password.length(); i++) {
                if(password.charAt(i)==password.charAt(i-1)){
                    return false;
                }
                if(password.charAt(i)>='a'&&password.charAt(i)<='z'){
                    low=true;
                } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                    high=true;
                } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    num=true;
                } else{
                    special=true;
                }
            }
            return low&&high&&num&&special;
        }
    }

    @Test
    public void test1(){
        String password="IloveLe3tcode!";
        System.out.println(strongPasswordCheckerII(password));
    }
}
