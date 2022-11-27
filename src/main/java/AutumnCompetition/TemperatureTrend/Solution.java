package AutumnCompetition.TemperatureTrend;

import org.junit.Test;

public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int tendencyA;
        int tendencyB;
        int maxDays=0,day=0;
        for (int i = 0; i < temperatureA.length-1; i++) {
            tendencyA=temperatureA[i+1]-temperatureA[i];
            tendencyB=temperatureB[i+1]-temperatureB[i];
            if(tendencyA*tendencyB>0||(tendencyA==0&&tendencyB==0)){
                day++;
            }else{
                if(day>maxDays){
                    maxDays=day;
                }
                day=0;
            }
        }
        if(day>maxDays){
            maxDays=day;
        }
        return maxDays;
    }
    @Test
    public void test(){
        int[] temperatureA={5,10,16,-6,15,11,3};
        int[] temperatureB={16,22,23,23,25,3,-16};
        System.out.println(temperatureTrend(temperatureA,temperatureB));
    }
}
