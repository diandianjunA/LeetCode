package EveryDayExercise.MaximumUnits;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[1]-o2[1]);
            }
        });
        int res=0;
        int size=0;
        for (int i = 0; (i < boxTypes.length)&&(size<truckSize); i++) {
            if(size+boxTypes[i][0]<=truckSize){
                size+=boxTypes[i][0];
                res+=boxTypes[i][0]*boxTypes[i][1];
            }else{
                res+=boxTypes[i][1]*(truckSize-size);
                return res;
            }
        }
        return res;
    }
}
