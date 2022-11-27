package DataStructureLearningPlan.GenerateSpiralMatrix;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        Status status = Status.RIGHT;
        int p=0,q=0;
        res[p][q]=1;
        for (int i = 2; i <= n * n; i++) {
            switch (status){
                case UP:
                    if(p-1>=0&&res[p-1][q]==0){
                        p--;
                        res[p][q]=i;
                    }else{
                        status=Status.RIGHT;
                        i--;
                    }
                    break;
                case DOWN:
                    if(p+1<n&&res[p+1][q]==0){
                        p++;
                        res[p][q]=i;
                    }else{
                        status=Status.LEFT;
                        i--;
                    }
                    break;
                case LEFT:
                    if(q-1>=0&&res[p][q-1]==0){
                        q--;
                        res[p][q]=i;
                    }else{
                        status=Status.UP;
                        i--;
                    }
                    break;
                case RIGHT:
                    if(q+1<n&&res[p][q+1]==0){
                        q++;
                        res[p][q]=i;
                    }else{
                        status=Status.DOWN;
                        i--;
                    }
                    break;
            }
        }
        return res;
    }
    @Test
    public void test(){
        for (int[] ints : generateMatrix(4)) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
enum Status{
    LEFT,DOWN,RIGHT,UP;
}