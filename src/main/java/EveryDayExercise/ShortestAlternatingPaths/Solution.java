package EveryDayExercise.ShortestAlternatingPaths;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];
        Queue<Integer> redQueue = new LinkedList<>();
        Queue<Integer> blueQueue = new LinkedList<>();
        int[] redDistance = new int[n];
        int[] blueDistance = new int[n];
        Arrays.fill(redDistance,Integer.MAX_VALUE);
        Arrays.fill(blueDistance,Integer.MAX_VALUE);
        int[][] redMatrix = new int[n][n];
        int[][] blueMatrix = new int[n][n];
        for (int i = 0; i < redEdges.length; i++) {
            if(redEdges[i][0]==0){
                redDistance[redEdges[i][1]]=1;
                redQueue.add(redEdges[i][1]);
            }else{
                redMatrix[redEdges[i][0]][redEdges[i][1]]=1;
            }
        }
        for (int i = 0; i < blueEdges.length; i++) {
            if(blueEdges[i][0]==0){
                blueDistance[blueEdges[i][1]]=1;
                blueQueue.add(blueEdges[i][1]);
            }else{
                blueMatrix[blueEdges[i][0]][blueEdges[i][1]]=1;
            }
        }
        redVisited[0]=true;
        blueVisited[0]=true;
        while (redQueue.size()!=0||blueQueue.size()!=0){
            if(redQueue.size()!=0){
                Integer poll = redQueue.poll();
                if(!redVisited[poll]){
                    for (int i = 0; i < blueMatrix[poll].length; i++) {
                        if(blueMatrix[poll][i]!=0){
                            if(blueDistance[i]>redDistance[poll]+1){
                                blueDistance[i]=redDistance[poll]+1;
                            }
                            if(!blueVisited[i]){
                                blueQueue.add(i);
                            }
                        }
                    }
                    redVisited[poll]=true;
                }
            }else{
                Integer poll = blueQueue.poll();
                if(!blueVisited[poll]){
                    for (int i = 0; i < redMatrix[poll].length; i++) {
                        if(redMatrix[poll][i]!=0){
                            if(redDistance[i]>blueDistance[poll]+1){
                                redDistance[i]=blueDistance[poll]+1;
                            }
                            if(!redVisited[i]){
                                redQueue.add(i);
                            }
                        }
                    }
                    blueVisited[poll]=true;
                }
            }
        }
        int[] answer = new int[n];
        for (int i = 1; i < n; i++) {
            answer[i]=Math.min(redDistance[i],blueDistance[i]);
            if(answer[i]==Integer.MAX_VALUE){
                answer[i]=-1;
            }
        }
        return answer;
    }

    @Test
    public void test1(){
        int n=3;
        int[][] redEdge={{0,1},{1,2}};
        int[][] blueEdge={};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n,redEdge,blueEdge)));
    }

    @Test
    public void test2(){
        int n=3;
        int[][] redEdge={{0,1}};
        int[][] blueEdge={{2,1}};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n,redEdge,blueEdge)));
    }

    @Test
    public void test3(){
        int n=3;
        int[][] redEdge={{1,0}};
        int[][] blueEdge={{2,1}};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n,redEdge,blueEdge)));
    }

    @Test
    public void test4(){
        int n=3;
        int[][] redEdge={{0,1}};
        int[][] blueEdge={{1,2}};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n,redEdge,blueEdge)));
    }

    @Test
    public void test5(){
        int n=3;
        int[][] redEdge={{0,1},{0,2}};
        int[][] blueEdge={{1,0}};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n,redEdge,blueEdge)));
    }
}
