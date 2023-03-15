package EveryDayExercise.RestoreMatrix;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int minR=Integer.MAX_VALUE;
        for (int i = 0; i < rowSum.length; i++) {
            if(rowSum[i]<minR){
                minR=rowSum[i];
            }
        }
        int minC=Integer.MAX_VALUE;
        for (int i = 0; i < colSum.length; i++) {
            if(colSum[i]<minC){
                minC=colSum[i];
            }
        }
        int[] curRow = new int[rowSum.length];
        int[] curCol = new int[colSum.length];
        int x=Math.min(minR,minC);
        for (int i = 0; i < Math.min(res.length,res[0].length); i++) {
            res[i][i]=x;
            curCol[i]=x;
            curRow[i]=x;
        }
        for (int i = 0; i < rowSum.length; i++) {
            if(rowSum[i]==curRow[i]){
                continue;
            }
            for (int j = 0; j < res[i].length; j++) {
                if(res[i][j]==0){
                    res[i][j]=rowSum[i]-curRow[i];
                    curCol[j]+=rowSum[i]-curRow[i];
                    curRow[i]+=rowSum[i]-curRow[i];
                }
            }
        }
        for (int i = 0; i < colSum.length; i++) {
            if(colSum[i]==curCol[i]||i==colSum.length-1){
                continue;
            }
            if(curCol[i]>colSum[i]){
                int gap=curCol[i]-colSum[i];
                for (int j = 0; j < rowSum.length&&gap>0; j++) {
                    if(res[j][i]>0){
                        int cut=Math.min(gap,res[j][i]);
                        res[j][i]-=cut;
                        curCol[i]-=cut;
                        res[j][i+1]+=cut;
                        curCol[i+1]+=cut;
                        gap-=cut;
                    }
                }
            }else{
                int gap=colSum[i]-curCol[i];
                for (int j = 0; j < rowSum.length&&gap>0; j++) {
                    int cut=Math.min(gap,curRow[j]);
                    res[j][i]+=cut;
                    curCol[i]+=cut;
                    for (int k = i+1; k < colSum.length&&cut>0; k++) {
                        int cut2=Math.min(cut,res[j][k]);
                        res[j][k]-=cut2;
                        curCol[j]-=cut2;
                        cut-=cut2;
                    }
                    gap-=cut;
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] rowSum={3,8};
        int[] colSum={4,7};
        for (int[] ints : restoreMatrix(rowSum, colSum)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test2(){
        int[] rowSum={5,7,10};
        int[] colSum={8,6,8};
        for (int[] ints : restoreMatrix(rowSum, colSum)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test3(){
        int[] rowSum={14,9};
        int[] colSum={6,9,8};
        for (int[] ints : restoreMatrix(rowSum, colSum)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test4(){
        int[] rowSum={1,0};
        int[] colSum={1};
        for (int[] ints : restoreMatrix(rowSum, colSum)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test5(){
        int[] rowSum={0};
        int[] colSum={0};
        for (int[] ints : restoreMatrix(rowSum, colSum)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
