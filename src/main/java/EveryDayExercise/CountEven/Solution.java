package EveryDayExercise.CountEven;

import org.junit.Test;

public class Solution {
    public int countEven(int num) {
        if(num==0){
            return 0;
        }
        int sum=0;
        int temp=num;
        while(num>0){
            sum=sum+num%10;
            num=num/10;
        }
        if(sum%2==0){
            return 1+countEven(temp-1);
        }else{
            return countEven(temp-1);
        }
    }

    @Test
    public void test1(){
        System.out.println(countEven(4));
    }
}
