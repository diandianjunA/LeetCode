package EveryDayExercise.BestCoordinate;

import org.junit.Test;

public class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] radio = new int[51][51];
        int max=0;
        int[] res = new int[2];
        for (int k = 0; k < towers.length; k++) {
            for (int i = 0; i < 51; i++) {
                for (int j = 0; j < 51; j++) {
                    double distance=Math.sqrt(Math.pow(towers[k][0]-i,2)+Math.pow(towers[k][1]-j,2));
                    if(distance<=radius){
                        radio[i][j]+= towers[k][2] /(1+distance);
                        if(max<radio[i][j]){
                            max=radio[i][j];
                            res[0]=i;
                            res[1]=j;
                        } else if (max == radio[i][j]) {
                            if(i<res[0]){
                                res[0]=i;
                                res[1]=j;
                            } else if (i == res[0]) {
                                if(j<res[1]){
                                    res[1]=j;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    @Test
    public void test1(){
        int[][] tower={{1,2,5},{2,1,7},{3,1,9}};
        int radius=2;
        for (int i : bestCoordinate(tower, radius)) {
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        int[][] tower={{50,20,31},{43,36,29}};
        int radius=38;
        for (int i : bestCoordinate(tower, radius)) {
            System.out.println(i);
        }
    }

    @Test
    public void test3(){
        int[][] tower={{33,24,12},{5,34,12},{9,45,6},{28,12,12}};
        int radius=2;
        for (int i : bestCoordinate(tower, radius)) {
            System.out.println(i);
        }
    }
}
