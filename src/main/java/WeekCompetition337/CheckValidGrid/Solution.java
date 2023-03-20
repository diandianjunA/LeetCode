package WeekCompetition337.CheckValidGrid;

import org.junit.Test;

public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]==0){
            return check(grid,0,0,0);
        }else{
            return false;
        }
    }

    public boolean check(int[][] grid,int i,int x,int y){
        if(i== grid.length*(grid.length)-1){
            return true;
        }
        if(checkRight(grid,x-1,y-2)){
            if(grid[x-1][y-2]==i+1){
                return check(grid, i+1, x-1, y-2);
            }
        }
        if(checkRight(grid,x-2,y-1)){
            if(grid[x-2][y-1]==i+1){
                return check(grid, i+1, x-2, y-1);
            }
        }
        if(checkRight(grid,x+1,y-2)){
            if(grid[x+1][y-2]==i+1){
                return check(grid, i+1, x+1, y-2);
            }
        }
        if(checkRight(grid,x+2,y-1)){
            if(grid[x+2][y-1]==i+1){
                return check(grid, i+1, x+2, y-1);
            }
        }
        if(checkRight(grid,x-1,y+2)){
            if(grid[x-1][y+2]==i+1){
                return check(grid, i+1, x-1, y+2);
            }
        }
        if(checkRight(grid,x-2,y+1)){
            if(grid[x-2][y+1]==i+1){
                return check(grid, i+1, x-2, y+1);
            }
        }
        if(checkRight(grid,x+1,y+2)){
            if(grid[x+1][y+2]==i+1){
                return check(grid, i+1, x+1, y+2);
            }
        }
        if(checkRight(grid,x+2,y+1)){
            if(grid[x+2][y+1]==i+1){
                return check(grid, i+1, x+2, y+1);
            }
        }
        return false;
    }

    public boolean checkRight(int[][] grid,int x,int y){
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    @Test
    public void test1(){
        int[][] grid={{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        System.out.println(checkValidGrid(grid));
    }

    @Test
    public void test2(){
        int[][] grid={{0,3,6},{5,8,1},{2,7,4}};
        System.out.println(checkValidGrid(grid));
    }

    @Test
    public void test3(){
        int[][] grid={{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}};
        System.out.println(checkValidGrid(grid));
    }
}
