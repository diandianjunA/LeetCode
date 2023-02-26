package EveryDayExercise.MaximumScore;

import java.util.Arrays;

public class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] stone = new int[3];
        stone[0]=a;
        stone[1]=b;
        stone[2]=c;
        Arrays.sort(stone);
        int res=0;
        while (true){
            if(stone[1]==0){
                return res;
            }
            stone[1]--;
            stone[2]--;
            res++;
            Arrays.sort(stone);
        }
    }
}

class Solution2 {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxVal = Math.max(Math.max(a, b), c);
        return Math.min(sum - maxVal, sum / 2);
    }
}