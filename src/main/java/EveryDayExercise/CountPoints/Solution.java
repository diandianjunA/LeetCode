package EveryDayExercise.CountPoints;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(Math.sqrt((points[j][0]-queries[i][0])*(points[j][0]-queries[i][0])+(points[j][1]-queries[i][1])*(points[j][1]-queries[i][1]))<=queries[i][2]){
                    answers[i]++;
                }
            }
        }
        return answers;
    }

    @Test
    public void test1(){
        int[][] answer={{1,3},{3,3},{5,3},{2,2}};
        int[][] queries={{2,3,1},{4,3,1},{1,1,2}};
        System.out.println(Arrays.toString(countPoints(answer,queries)));
    }
}
