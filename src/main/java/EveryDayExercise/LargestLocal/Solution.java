package EveryDayExercise.LargestLocal;

import org.junit.Test;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] record = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i-1>=0){
                    if(j-1>=0){
                        record[i-1][j-1]=Math.max(grid[i][j],record[i-1][j-1]);
                    }
                    record[i-1][j]=Math.max(grid[i][j],record[i-1][j]);
                    if(j+1<grid[i].length){
                        record[i-1][j+1]=Math.max(grid[i][j],record[i-1][j+1]);
                    }
                }
                if(j-1>=0){
                    record[i][j-1]=Math.max(grid[i][j],record[i][j-1]);
                }
                record[i][j]=Math.max(grid[i][j],record[i][j]);
                if(j+1<grid[i].length){
                    record[i][j+1]=Math.max(grid[i][j],record[i][j+1]);
                }
                if(i+1<grid.length){
                    if(j-1>=0){
                        record[i+1][j-1]=Math.max(grid[i][j],record[i+1][j-1]);
                    }
                    record[i+1][j]=Math.max(grid[i][j],record[i+1][j]);
                    if(j+1<grid[i].length){
                        record[i+1][j+1]=Math.max(grid[i][j],record[i+1][j+1]);
                    }
                }
            }
        }
        int[][] res = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = record[i + 1][j + 1];
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[][] grid={{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] res=largestLocal(grid);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test2(){
        int[][] grid={{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[][] res=largestLocal(grid);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
