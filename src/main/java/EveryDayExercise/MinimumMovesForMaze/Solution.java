package EveryDayExercise.MinimumMovesForMaze;

import org.junit.Test;

public class Solution {
    public int minimumMoves(int[][] grid) {
        int[][] location = new int[2][2];
        location[0]= new int[]{0, 0};
        location[1]= new int[]{0, 1};
        int[][] visitRow = new int[grid.length][grid.length];
        int[][] visitCol = new int[grid.length][grid.length];
        int res = Move(grid, location, visitRow, visitCol);
        if(res==100001){
            return -1;
        }else {
            return res;
        }
    }

    public int Move(int[][] grid,int[][] location,int[][] visitRow,int[][] visitCol){
        if(location[0][0]== grid.length-1&&location[0][1]==grid.length-2&&location[1][0]==grid.length-1&&location[1][1]==grid.length-1){
            return 0;
        }
        int right=100000;
        int down=100000;
        int downRotate=100000;
        int rightRotate=100000;
        if(location[0][0]==location[1][0]){
            if(visitRow[location[1][0]][location[1][1]]!=0){
                return visitRow[location[1][0]][location[1][1]];
            }
            visitRow[location[1][0]][location[1][1]]=100000;
            if(location[1][1]+1< grid.length&&grid[location[1][0]][location[1][1]+1]!=1){
                int[][] newLocation = new int[2][2];
                newLocation[0]=new int[]{location[0][0],location[0][1]+1};
                newLocation[1]=new int[]{location[1][0],location[1][1]+1};
                right=Move(grid,newLocation,visitRow,visitCol);
            }
            if(location[0][0]+1<grid.length&&grid[location[1][0]+1][location[1][1]]!=1&&grid[location[0][0]+1][location[0][1]]!=1){
                int[][] newLocation = new int[2][2];
                newLocation[0]=new int[]{location[0][0]+1,location[0][1]};
                newLocation[1]=new int[]{location[1][0]+1,location[1][1]};
                down=Move(grid,newLocation,visitRow,visitCol);
            }
            if(location[0][0]+1<grid.length&&grid[location[0][0]+1][location[0][1]]!=1&&grid[location[1][0]+1][location[1][1]]!=1){
                int[][] newLocation = new int[2][2];
                newLocation[0]=new int[]{location[0][0],location[0][1]};
                newLocation[1]=new int[]{location[0][0]+1,location[0][1]};
                rightRotate=Move(grid,newLocation,visitRow,visitCol);
            }
            return visitRow[location[1][0]][location[1][1]]=Math.min(Math.min(right,rightRotate),Math.min(down,downRotate))+1;
        }else{
            if(visitCol[location[1][0]][location[1][1]]!=0){
                return visitCol[location[1][0]][location[1][1]];
            }
            visitCol[location[1][0]][location[1][1]]=100000;
            if(location[0][1]+1<grid.length&&grid[location[1][0]][location[1][1]+1]!=1&&grid[location[0][0]][location[0][1]+1]!=1){
                int[][] newLocation = new int[2][2];
                newLocation[0]=new int[]{location[0][0],location[0][1]+1};
                newLocation[1]=new int[]{location[1][0],location[1][1]+1};
                right=Move(grid,newLocation,visitRow,visitCol);
            }
            if(location[1][0]+1< grid.length&&grid[location[1][0]+1][location[1][1]]!=1){
                int[][] newLocation = new int[2][2];
                newLocation[0]=new int[]{location[0][0]+1,location[0][1]};
                newLocation[1]=new int[]{location[1][0]+1,location[1][1]};
                down=Move(grid,newLocation,visitRow,visitCol);
            }
            if(location[0][1]+1<grid.length&&grid[location[0][0]][location[0][1]+1]!=1&&grid[location[1][0]][location[1][1]+1]!=1){
                int[][] newLocation = new int[2][2];
                newLocation[0]=new int[]{location[0][0],location[0][1]};
                newLocation[1]=new int[]{location[0][0],location[0][1]+1};
                downRotate=Move(grid,newLocation,visitRow,visitCol);
            }
            return visitCol[location[1][0]][location[1][1]]=Math.min(Math.min(right,rightRotate),Math.min(down,downRotate))+1;
        }
    }

    @Test
    public void test1(){
        int[][] grid={{0,0,0,0,0,1},
                {1,1,0,0,1,0},
                {0,0,0,0,1,1},
                {0,0,1,0,1,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0}};
        System.out.println(minimumMoves(grid));
    }

    @Test
    public void test2(){
        int[][] grid={{0,0,1,1,1,1},
                {0,0,0,0,1,1},
                {1,1,0,0,0,1},
                {1,1,1,0,0,1},
                {1,1,1,0,0,1},
                {1,1,1,0,0,0}};
        System.out.println(minimumMoves(grid));
    }

    @Test
    public void test3(){
        int[][] grid={{0,0,0,0,1,1},{1,1,0,0,0,1},{1,1,1,0,0,1},{1,1,1,0,1,1},{1,1,1,0,0,1},{1,1,1,0,0,0}};
        System.out.println(minimumMoves(grid));
    }

    @Test
    public void test4(){
        int[][] grid={{0,0,0,0,1,1},{1,1,0,0,0,1},{1,1,1,0,0,1},{1,1,1,0,1,1},{1,1,1,0,0,1},{1,1,1,0,0,0}};
        System.out.println(minimumMoves(grid));
    }

    @Test
    public void test5(){
        int[][] grid={{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,1,0,0,1,0,0,0,0,1,0,0},{0,1,0,0,0,0,1,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,1,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,0,0,1,0,0,0,1,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{1,0,0,0,0,0,1,0,0,0,1,0,0,0,1},{0,0,1,0,1,0,0,0,0,0,0,0,0,0,0}};
        System.out.println(minimumMoves(grid));
    }

    @Test
    public void test6(){
        int[][] grid={{0,0,0,0,0,0,0,1,0,0,1,0,0,0,0},{1,0,0,0,0,1,0,0,0,0,0,0,1,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,1,0,1,0,0,0,0,1,0,0,1,0,0},{0,0,0,0,0,0,0,1,0,0,0,0,0,1,0},{1,0,0,0,1,0,0,0,0,0,0,0,1,0,1},{1,0,0,0,0,0,0,0,0,0,0,1,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{1,0,0,0,0,0,1,0,0,0,0,0,1,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},{0,1,0,0,1,0,1,0,0,0,1,0,1,1,0},{0,1,0,1,1,0,0,0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,1,0,0,0,1,0,1,0,0},{0,0,0,0,0,1,0,0,1,0,0,1,0,0,0}}
                ;
        System.out.println(minimumMoves(grid));
    }
}
