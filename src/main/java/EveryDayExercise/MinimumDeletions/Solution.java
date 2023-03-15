package EveryDayExercise.MinimumDeletions;

import org.junit.Test;

public class Solution {
    public int minimumDeletions(String s) {
        int[] aNum = new int[s.length()+1];
        int[] bNum = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a'){
                aNum[i+1]=aNum[i]+1;
                bNum[i+1]=bNum[i];
            }else{
                aNum[i+1]=aNum[i];
                bNum[i+1]=bNum[i]+1;
            }
        }
        int minOperation=Integer.MAX_VALUE;
        int r2=Math.min(aNum[aNum.length-1],bNum[bNum.length-1]);
        for (int i = 1; i <= s.length(); i++) {
            int r1=bNum[i-1]+aNum[aNum.length-1]-aNum[i-1];
            minOperation=Math.min(minOperation,Math.min(r1,r2));
        }
        return minOperation;
    }

    @Test
    public void test1(){
        String s="aababbab";
        System.out.println(minimumDeletions(s));
    }

    @Test
    public void test2(){
        String s="bbaaaaabb";
        System.out.println(minimumDeletions(s));
    }

    @Test
    public void test3(){
        String s="aabbaababbababaabbbaabbbbaababababbabbbababbabbaabaaabbbbbbaaabbbbabaababbaaabbbbaaabababbbaaa";
        System.out.println(minimumDeletions(s));
    }

    @Test
    public void test4(){
        String s="a";
        System.out.println(minimumDeletions(s));
    }
}
