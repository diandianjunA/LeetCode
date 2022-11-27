package EveryDayExercise.OrderOfLargestPlusSign;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int orderOfLargestPlusSign(int n,int[][] mines){
        int k=(n+1)/2;
        int[][] grid = new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i],1);
        }
        for (int i = 0; i < mines.length; i++) {
            grid[mines[i][0]][mines[i][1]]=0;
        }
        boolean isValid;
        for (int i = k; i >0; i--) {
            isValid=false;
            outer: for (int j = i-1; j <n-i+1; j++) {
                for (int l = i-1; l < n-i+1; l++) {
                    if(check(grid, i, j, l)){
                        isValid=true;
                        break outer;
                    }
                }
            }
            if(isValid){
                return i;
            }
        }
        return 0;
    }
    public boolean check(int[][] grid,int k,int x,int y){
        for (int i = x-k+1; i < x + k; i++) {
            if(grid[i][y]==0){
                return false;
            }
        }
        for (int i = y-k+1; i <y+k; i++) {
            if(grid[x][i]==0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test1(){
        int n=5;
        int[][] mines={{4,2}};
        System.out.println(orderOfLargestPlusSign(n,mines));
    }
    @Test
    public void test2(){
        int n=1;
        int[][] mines={{0,0}};
        System.out.println(orderOfLargestPlusSign(n,mines));
    }
    @Test
    public void test3(){
        int n=1;
        int[][] mines={};
        System.out.println(orderOfLargestPlusSign(n,mines));
    }
    @Test
    public void test4(){
        int n=2;
        int[][] mines={{0,0},{0,1},{1,0}};
        System.out.println(orderOfLargestPlusSign(n,mines));
    }
    @Test
    public void test5(){
        int n=3;
        int[][] mines={{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        System.out.println(orderOfLargestPlusSign(n,mines));
    }
}
