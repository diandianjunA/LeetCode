package EveryDayExercise.MaximalNetworkRank;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int max=0;
        int[][] map = new int[n][n];
        int[] paths = new int[n];
        for (int i = 0; i < roads.length; i++) {
            map[roads[i][0]][roads[i][1]]=1;
            map[roads[i][1]][roads[i][0]]=1;
            paths[roads[i][0]]++;
            paths[roads[i][1]]++;
        }
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths.length; j++) {
                if(i==j){
                    continue;
                }
                int num=paths[i]+paths[j]-map[i][j];
                if(num>max){
                    max=num;
                }
            }
        }
        return max;
    }

    @Test
    public void test1(){
        int n=4;
        int[][] roads={{0,1},{0,3},{1,2},{1,3}};
        System.out.println(maximalNetworkRank(n,roads));
    }

    @Test
    public void test2(){
        int n=5;
        int[][] roads={{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        System.out.println(maximalNetworkRank(n,roads));
    }

    @Test
    public void test3(){
        int n=8;
        int[][] roads={{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        System.out.println(maximalNetworkRank(n,roads));
    }
}
