package EveryDayExercise.MaxHeight;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            int x;
            int y;
            int z;
            if (cuboid[0] < cuboid[1]) {
                if (cuboid[1] < cuboid[2]) {
                    x = cuboid[0];
                    y = cuboid[1];
                    z = cuboid[2];
                } else {
                    if (cuboid[0] < cuboid[2]) {
                        x = cuboid[0];
                        y = cuboid[2];
                    } else {
                        x = cuboid[2];
                        y = cuboid[0];
                    }
                    z = cuboid[1];
                }
            } else {
                if (cuboid[0] < cuboid[2]) {
                    x = cuboid[1];
                    y = cuboid[0];
                    z = cuboid[2];
                } else {
                    if (cuboid[1] < cuboid[2]) {
                        x = cuboid[1];
                        y = cuboid[2];
                    } else {
                        x = cuboid[2];
                        y = cuboid[1];
                    }
                    z = cuboid[0];
                }
            }
            cuboid[0]=x;
            cuboid[1]=y;
            cuboid[2]=z;
        }
        Arrays.sort(cuboids, (o1, o2) -> {
            if(o1[0]>o2[0]){
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            }else {
                if(o1[1]>o2[1]){
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                }else{
                    if(o1[2]>o2[2]){
                        return 1;
                    } else if (o1[2] < o2[2]) {
                        return -1;
                    }
                }
            }
            return 0;
        });
        int[] dp = new int[cuboids.length];
        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                if(cuboids[j][0]<cuboids[i][0]&&cuboids[j][1]<cuboids[i][1]&&cuboids[j][2]<cuboids[i][2]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]=dp[i]+cuboids[i][2];
        }
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
