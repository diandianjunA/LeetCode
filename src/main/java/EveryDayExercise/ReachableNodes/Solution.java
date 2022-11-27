package EveryDayExercise.ReachableNodes;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] matrix = new int[n][n];
        int MaxDistance=1000000007;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    matrix[i][j]=0;
                }else {
                    matrix[i][j]=MaxDistance;
                }
            }
        }
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2]+1;
            matrix[edge[1]][edge[0]] = edge[2]+1;
        }
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n];
//        visited[0]=true;
        int res=1;
//        for (int i = 1; i < matrix[0].length; i++) {
//            if(!visited[i]&&matrix[0][i]<MaxDistance){
//                queue.offer(i);
//                visited[i]=true;
//            }
//        }
//        while (!queue.isEmpty()){
//            Integer i = queue.poll();
//            for (int j = 1; j < n; j++) {
//                if(matrix[0][j]>matrix[0][i]+matrix[i][j]){
//                    matrix[0][j]=matrix[0][i]+matrix[i][j];
//                    update(matrix,j);
//                }
//                if(!visited[j]&&matrix[i][j]<MaxDistance){
//                    queue.offer(j);
//                    visited[j]=true;
//                }
//            }
//        }
        dijstra(matrix,0);
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i]<=maxMoves){
                res++;
            }
        }
        for (int[] edge : edges) {
            res += Math.min(Math.max(0,maxMoves - matrix[0][edge[0]]) + Math.max(0,maxMoves - matrix[0][edge[1]]), edge[2]);
        }
        return res;
    }
    public void update(int[][] matrix,int i){
        for (int j = 1; j < matrix.length; j++) {
            if(matrix[0][j]>matrix[0][i]+matrix[i][j]){
                matrix[0][j]=matrix[0][i]+matrix[i][j];
                update(matrix,j);
            }
        }
    }
    public void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                }
            }
        }
    }

    @Test
    public void test1(){
        int[][] edges = {{0,1,10},{0, 2, 1}, {1, 2, 2}};
        int maxMoves = 6;
        int n = 3;
        System.out.println(reachableNodes(edges,maxMoves,n));
    }

    @Test
    public void test2(){
        int[][] edges = {{0,1,4},{1,2,6},{0,2,8},{1,3,1}};
        int maxMoves = 10;
        int n = 4;
        System.out.println(reachableNodes(edges,maxMoves,n));
    }

    @Test
    public void test3(){
        int[][] edges = {{1,2,4},{1,4,5},{1,3,1},{2,3,4},{3,4,5}};
        int maxMoves = 17;
        int n = 5;
        System.out.println(reachableNodes(edges,maxMoves,n));
    }

    @Test
    public void test4(){
        int[][] edges = {{1,2,5},{0,3,3},{1,3,2},{2,3,4},{0,4,1}};
        int maxMoves = 7;
        int n = 5;
        System.out.println(reachableNodes(edges,maxMoves,n));
    }

    @Test
    public void test5(){
        int[][] edges = {{0,2,9},{0,1,6},{3,4,7},{2,3,8},{1,2,0},{2,4,0},{0,4,9},{0,3,0},{1,4,2},{1,3,0}};
        int maxMoves = 3;
        int n = 5;
        System.out.println(reachableNodes(edges,maxMoves,n));
    }
}
