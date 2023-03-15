package EveryDayExercise.MaxValueFor2704;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int maxValue(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i],-1);
        }
        return getValue(grid,0,0,cache);
    }

    public int getValue(int[][] grid,int x,int y,int[][] cache){
        if(x==grid.length-1&&y==grid[0].length-1){
            return grid[x][y];
        }
        if(cache[x][y]!=-1){
            return cache[x][y];
        }
        int down=0;
        int right=0;
        if(x+1<grid.length){
            down=getValue(grid,x+1,y,cache);
        }
        if(y+1<grid[0].length){
            right=getValue(grid,x,y+1,cache);
        }
        return cache[x][y]=grid[x][y]+Math.max(down,right);
    }

    @Test
    public void test1(){
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(grid));
    }
}
