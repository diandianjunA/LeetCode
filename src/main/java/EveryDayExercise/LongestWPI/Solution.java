package EveryDayExercise.LongestWPI;

import org.junit.Test;

public class Solution {
    public int longestWPI(int[] hours) {
        int[] pre = new int[hours.length+1];
        for (int i = 0; i < hours.length; i++) {
            if(hours[i]>8){
                pre[i+1]=pre[i]+1;
            }else {
                pre[i+1]=pre[i]-1;
            }
        }
        int maxRes=0;
        for (int i = hours.length; i >=maxRes ; i--) {
            for (int j = 0; j < i-maxRes+1; j++) {
                if(pre[i]-pre[j]>0){
                    maxRes=Math.max(maxRes,i-j);
                    break;
                }
            }
        }
        return maxRes;
    }

    @Test
    public void test1(){
        int[] hours={9,9,6,0,6,6,9};
        System.out.println(longestWPI(hours));
    }

    @Test
    public void test2(){
        int[] hours={6,6,6};
        System.out.println(longestWPI(hours));
    }
}
