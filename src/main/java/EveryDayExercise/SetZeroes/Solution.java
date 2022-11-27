package EveryDayExercise.SetZeroes;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false,col = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                col=true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                row=true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        if(row){
            Arrays.fill(matrix[0],0);
        }
        if(col){
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0]=0;
            }
        }
    }
    @Test
    public void test(){
        int[][] arr={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(arr);
        for (int[] array : arr) {
            System.out.println(Arrays.toString(array));
        }
    }
}
