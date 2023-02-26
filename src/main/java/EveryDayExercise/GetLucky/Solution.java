package EveryDayExercise.GetLucky;

import org.junit.Test;

public class Solution {
    public int getLucky(String s, int k) {
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            int num=s.charAt(i)-'a'+1;
            res=res+num/10+num%10;
        }
        for (int i = 1; i < k; i++) {
            int temp=res;
            res=0;
            while(temp>0){
                res+=temp%10;
                temp=temp/10;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String s="iaozzbyqzwbpurzze";
        int k=2;
        System.out.println(getLucky(s,k));
    }
}
