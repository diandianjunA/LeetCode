package EveryDayExercise.ShortestBridge;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int shortestBridge(int[][] grid) {
        int isLand=2;
        int p = 0,q = 0;
        outer:for (int i = 0; i < grid.length; i++) {
            inner:for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    grid[i][j]=isLand;
                    dfs(grid,i,j,isLand);
                    p=i;
                    q=j;
                    break outer;
                }
            }
        }
        isLand=3;
        outer:for (int i = 0; i < grid.length; i++) {
            inner:for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    grid[i][j]=isLand;
                    dfs(grid,i,j,isLand);
                    break outer;
                }
            }
        }
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        isVisited[p][q]=true;
        return findWay(grid,p,q, 0,isVisited);
    }
    public void dfs(int[][] grid,int x,int y,int isLand){
        if(x-1>=0){
            if(grid[x-1][y]==1){
                grid[x-1][y]=isLand;
                dfs(grid,x-1,y,isLand);
            }
        }
        if(x+1< grid.length){
            if(grid[x+1][y]==1){
                grid[x+1][y]=isLand;
                dfs(grid,x+1,y,isLand);
            }
        }
        if(y-1>=0){
            if(grid[x][y-1]==1){
                grid[x][y-1]=isLand;
                dfs(grid,x,y-1,isLand);
            }
        }
        if(y+1< grid.length){
            if(grid[x][y+1]==1){
                grid[x][y+1]=isLand;
                dfs(grid,x,y+1,isLand);
            }
        }
    }
    public int findWay(int[][] grid,int x,int y,int step,boolean[][] isVisited){
        int way1=Integer.MAX_VALUE;
        int way2=Integer.MAX_VALUE;
        int way3=Integer.MAX_VALUE;
        int way4=Integer.MAX_VALUE;
        if(x-1>=0){
            if(grid[x-1][y]==0){
                grid[x-1][y]=1;
                isVisited[x-1][y]=true;
                way1 = findWay(grid, x - 1, y, step + 1,isVisited);
                grid[x-1][y]=0;
            } else if (grid[x][y]==2&&grid[x - 1][y] == 2&&!isVisited[x-1][y]) {
                isVisited[x-1][y]=true;
                way1=Math.min(way1,findWay(grid, x-1, y, step, isVisited));
            } else if (grid[x - 1][y] == 3) {
                return step;
            }
        }
        if(x+1< grid.length){
            if(grid[x+1][y]==0){
                grid[x+1][y]=1;
                isVisited[x+1][y]=true;
                way2 = findWay(grid, x + 1, y, step + 1,isVisited);
                grid[x+1][y]=0;
            } else if (grid[x][y]==2&&grid[x + 1][y] == 2&&!isVisited[x+1][y]) {
                isVisited[x+1][y]=true;
                way2=Math.min(way2,findWay(grid, x+1, y, step, isVisited));
            }  else if (grid[x + 1][y] == 3) {
                return step;
            }
        }
        if(y-1>=0){
            if(grid[x][y-1]==0){
                grid[x][y-1]=1;
                isVisited[x][y-1]=true;
                way3 = findWay(grid, x, y-1, step + 1,isVisited);
                grid[x][y-1]=0;
            } else if (grid[x][y]==2&&grid[x][y-1] == 2&&!isVisited[x][y-1]) {
                isVisited[x][y-1]=true;
                way2=Math.min(way2,findWay(grid, x, y-1, step, isVisited));
            } else if (grid[x][y-1] == 3) {
                return step;
            }
        }
        if(y+1< grid.length){
            if(grid[x][y+1]==0){
                grid[x][y+1]=1;
                isVisited[x][y+1]=true;
                way4 = findWay(grid, x, y+1, step + 1,isVisited);
                grid[x][y+1]=0;
            } else if (grid[x][y]==2&&grid[x][y+1] == 2&&!isVisited[x][y+1]) {
                isVisited[x][y+1]=true;
                way2=Math.min(way2,findWay(grid, x, y+1, step, isVisited));
            } else if (grid[x][y+1] == 3) {
                return step;
            }
        }
        return Math.min(Math.min(way1,way2),Math.min(way3,way4));
    }
    @Test
    public void test1(){
        int[][] grid={{0,1}, {1, 0}};
        System.out.println(shortestBridge(grid));
    }
    @Test
    public void test2(){
        int[][] grid={{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(shortestBridge(grid));
    }
    @Test
    public void test3(){
        int[][] grid={{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(shortestBridge(grid));
    }
    @Test
    public void test4(){
        int[][] grid={{0,0,0,0,0,0},{0,1,0,0,0,0},{1,1,0,0,0,0},{1,1,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,0,0}};
        System.out.println(shortestBridge(grid));
    }
    @Test
    public void test5(){
        int[][] grid={{0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0},{0,0,0,0,1,1,0,0},{0,0,0,1,1,0,1,0},{0,0,0,0,0,1,1,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        System.out.println(shortestBridge(grid));
    }
}
class Solution2 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new ArrayDeque<int[]>();
                    dfs(i, j, grid, queue);
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int x, int y, int[][] grid, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }
        queue.offer(new int[]{x, y});
        grid[x][y] = -1;
        dfs(x - 1, y, grid, queue);
        dfs(x + 1, y, grid, queue);
        dfs(x, y - 1, grid, queue);
        dfs(x, y + 1, grid, queue);
    }
}