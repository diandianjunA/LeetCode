package EveryDayExercise.SquareIsWhite;

import org.junit.Test;

public class Solution {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0)-'a')%2+(coordinates.charAt(1)-'1')%2+1)%2==0;
    }

    @Test
    public void test1(){
        System.out.println(squareIsWhite("a1"));
    }

    @Test
    public void test2(){
        System.out.println(squareIsWhite("h3"));
    }

    @Test
    public void test3(){
        System.out.println(squareIsWhite("c7"));
    }
}
