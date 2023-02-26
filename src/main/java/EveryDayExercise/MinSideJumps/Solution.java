package EveryDayExercise.MinSideJumps;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    static final int INF = 0x3fffffff;

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[] d = new int[3];
        Arrays.fill(d, 1);
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            int minCnt = INF;
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    d[j] = INF;
                } else {
                    minCnt = Math.min(minCnt, d[j]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    continue;
                }
                d[j] = Math.min(d[j], minCnt + 1);
            }
        }
        return Math.min(Math.min(d[0], d[1]), d[2]);
    }

    @Test
    public void test1(){
        int[] obstacles={0,1,2,3,0};
        System.out.println(minSideJumps(obstacles));
    }

    @Test
    public void test2(){
        int[] obstacles={0,1,1,3,3,0};
        System.out.println(minSideJumps(obstacles));
    }

    @Test
    public void test3(){
        int[] obstacles={0,2,1,0,3,0};
        System.out.println(minSideJumps(obstacles));
    }

    @Test
    public void test4(){
        int[] obstacles={0,0,3,1,0,1,0,2,3,1,0};
        System.out.println(minSideJumps(obstacles));
    }
}
