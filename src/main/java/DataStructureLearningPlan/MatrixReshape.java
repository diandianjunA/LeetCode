package DataStructureLearningPlan;

import org.junit.Test;

import java.util.Arrays;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c!=mat.length*mat[0].length){
            return mat;
        }
        int[][] res = new int[r][c];
        int p=0,q=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(q<c&&p<r){
                    res[p][q]=mat[i][j];
                    q++;
                }else{
                    p++;
                    q=0;
                    res[p][q]=mat[i][j];
                    q++;
                }
            }
        }
        return res;
    }
    public int[][] matrixReshapePro(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
    @Test
    public void test(){
        int[][] mat=new int[][]{{1,2},{3,4}};
        for (int[] ints : matrixReshape(mat, 4, 1)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
