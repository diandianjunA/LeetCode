package EveryDayExercise.CountDifferentSubsequenceGCDs;

import org.junit.Test;

public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max=0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        boolean[] map = new boolean[max + 1];
        for (int num : nums) {
            map[num] = true;
        }
        int res=0;
        for (int i = 1; i < max + 1; i++) {
            int g=0;
            for (int j = i; j < max+1; j=j+i) {
                if(map[j]){
                    g=gcd(g,j);
                    if(g==i){
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int gcd(int x,int y){
        int a=Math.max(x,y);
        int b=Math.min(x,y);
        if(b==0){
            return a;
        }
        int c=a%b;
        while(c!=0){
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }

    @Test
    public void test1(){
        int[] nums={6,10,3};
        System.out.println(countDifferentSubsequenceGCDs(nums));
    }
}
