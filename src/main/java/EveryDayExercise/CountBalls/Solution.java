package EveryDayExercise.CountBalls;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <=highLimit; i++) {
            byte[] bytes = (i + "").getBytes();
            int sum=0;
            for (byte aByte : bytes) {
                sum += aByte - '0';
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        int max=0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if(entry.getValue()>=max){
                max=entry.getValue();
            }
        }
        return max;
    }
}
