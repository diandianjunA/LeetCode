package EveryDayExercise.BestHand;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        String[] res = {"Flush", "Three of a Kind", "Pair", "High Card"};
        boolean is=true;
        for (int i = 1; i < suits.length; i++) {
            if(suits[i]!=suits[i-1]){
                is=false;
                break;
            }
        }
        if(is){
            return res[0];
        }
        int[] t = new int[13];
        for (int rank : ranks) {
            t[rank - 1]++;
        }
        int max=0;
        for (int j : t) {
            if (j > max) {
                max = j;
            }
        }
        if(max>=3){
            return res[1];
        }else if(max==2){
            return res[2];
        }else {
            return res[3];
        }
    }

    @Test
    public void test1(){
        int[] ranks={13,2,3,1,9};
        char[] suits={'a','a','a','a','a'};
        System.out.println(bestHand(ranks,suits));
    }
}

class Solution2{
    public String bestHand(int[] ranks, char[] suits) {
        if(suits[0]==suits[1]&&suits[0]==suits[2]&&suits[0]==suits[3]&&suits[0]==suits[4])
        {
            return "Flush";
        }
        Arrays.sort(ranks);
        if(ranks[0]==ranks[2] || ranks[1]==ranks[3] || ranks[2]==ranks[4])
        {
            return "Three of a Kind";
        }
        if(ranks[0]==ranks[1] || ranks[1]==ranks[2] || ranks[2]==ranks[3] || ranks[3]==ranks[4])
        {
            return "Pair";
        }
        return "High Card";
    }
}