package EveryDayExercise.LargestAltitude;

import org.junit.Test;

public class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int pre=0;
        for (int i = 1; i < gain.length+1; i++) {
            if(max<pre+gain[i-1]){
                max=pre+gain[i-1];
            }
            pre=pre+gain[i-1];
        }
        return max;
    }
    @Test
    public void test1(){
        int[] gain={-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
    @Test
    public void test2(){
        int[] gain={-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }
}
