package EveryDayExercise.ChampagneTower;

import org.junit.Test;

public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arrange=new double[query_row+2][query_row+2];
        arrange[0][0]=poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if(arrange[i][j]>1){
                    arrange[i+1][j]+=(arrange[i][j]-1)/2;
                    arrange[i+1][j+1]+=(arrange[i][j]-1)/2;
                    arrange[i][j]=1;
                }
            }
        }
        return arrange[query_row][query_glass];
    }
    @Test
    public void test1(){
        int poured=1;
        int query_row=1;
        int query_glass=1;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }

    @Test
    public void test2(){
        int poured=2;
        int query_row=1;
        int query_glass=1;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }

    @Test
    public void test3(){
        int poured=100000009;
        int query_row=33;
        int query_glass=17;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }

    @Test
    public void test4(){
        int poured=0;
        int query_row=0;
        int query_glass=0;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }

    @Test
    public void test5(){
        int poured=25;
        int query_row=6;
        int query_glass=1;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }

    @Test
    public void test6(){
        int poured=6;
        int query_row=2;
        int query_glass=0;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }
}
