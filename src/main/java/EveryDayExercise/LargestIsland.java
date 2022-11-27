package EveryDayExercise;

import org.junit.Test;

import java.util.*;

public class LargestIsland {
    public int largestIsland(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        Map<Integer,Integer> map=new HashMap<>();
        int index=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1&&temp[i][j]==0){
                    map.put(++index,dfs(grid,temp,i,j,index));
                }else if(grid[i][j]==0){
                    temp[i][j] = -1;
                }
            }
        }
        int maxIsland=0;
        int island=1;
        HashSet<Integer> islandSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(temp[i][j]!=-1){
                    continue;
                }
                if(i+1<grid.length&&temp[i+1][j]!=-1){
                    islandSet.add(temp[i+1][j]);
                }
                if(i-1>=0&&temp[i-1][j]!=-1){
                    islandSet.add(temp[i-1][j]);
                }
                if(j-1>=0&&temp[i][j-1]!=-1){
                    islandSet.add(temp[i][j-1]);
                }
                if(j+1< grid[0].length&&temp[i][j+1]!=-1){
                    islandSet.add(temp[i][j+1]);
                }
                if(!map.isEmpty()){
                    for(Integer in:islandSet){
                        island+=map.get(in);
                    }
                }

                if(island>maxIsland){
                    maxIsland=island;
                }
                islandSet.clear();
                island=1;
            }
        }
        if(maxIsland==0){
            return grid.length*grid.length;
        }
        return maxIsland;
    }
    public int dfs(int[][] grid,int[][] temp,int x,int y,int index){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return 0;
        }
        if(grid[x][y]==0){
            temp[x][y]=-1;
            return 0;
        }
        if(temp[x][y]!=0){
            return 0;
        }
        temp[x][y]=index;
        return 1+dfs(grid,temp,x+1,y,index)+dfs(grid,temp,x,y+1,index)+dfs(grid,temp,x-1,y,index)+dfs(grid,temp,x,y-1,index);
    }
    @Test
    public void test(){
        int[][] grid=new int[][]{{1,0,0,1,1},{1,0,0,1,0},{1,1,1,1,1},{1,1,1,0,1},{0,0,0,1,0}};
        System.out.println(largestIsland(grid));
    }
}
