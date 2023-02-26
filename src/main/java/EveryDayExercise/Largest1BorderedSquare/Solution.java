package EveryDayExercise.Largest1BorderedSquare;

import org.junit.Test;

public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int[][] tempX = new int[grid.length][grid[0].length];
        int[][] tempY = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        tempX[0][0]=grid[0][0];
        tempY[0][0]=grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],grid[i][0]);
            if(grid[i][0]==0){
                tempX[i][0]=0;
                tempY[i][0]=0;
            }else {
                tempX[i][0]=1;
                tempY[i][0]=tempY[i-1][0]+1;
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i]=Math.max(dp[0][i-1],grid[0][i]);
            if(grid[0][i]==0){
                tempX[0][i]=0;
                tempY[0][i]=0;
            }else {
                tempX[0][i]=tempX[0][i-1]+1;
                tempY[0][i]=1;
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if(grid[i][j]==0){
                    tempX[i][j]=0;
                    tempY[i][j]=0;
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }else {
                    tempX[i][j]=tempX[i][j-1]+1;
                    tempY[i][j]=tempY[i-1][j]+1;
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    int t=Math.min(tempX[i][j],tempY[i][j]);
                    for (int k = t; k > 0; k--) {
                        if(tempX[i-k+1][j]>=k&&tempY[i][j-k+1]>=k){
                            dp[i][j]=Math.max(dp[i][j],k);
                            break;
                        }
                    }
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1]*dp[grid.length-1][grid[0].length-1];
    }

    @Test
    public void test1(){
        int[][] grid={{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(largest1BorderedSquare(grid));
    }

    @Test
    public void test2(){
        int[][] grid={{1,1,0,0}};
        System.out.println(largest1BorderedSquare(grid));
    }

    @Test
    public void test3(){
        int[][] grid={{1,1,1},{0,1,0},{0,1,1},{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(largest1BorderedSquare(grid));
    }

    @Test
    public void test4(){
        int[][] grid={{0,1},{1,1}};
        System.out.println(largest1BorderedSquare(grid));
    }

    @Test
    public void test5(){
        int[][] grid={{1,1,0},{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(largest1BorderedSquare(grid));
    }
}
