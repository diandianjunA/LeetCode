package DataStructureLearningPlan.SearchMatrix;

import org.junit.Test;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int k= matrix[0].length;
        int j=0;
        int i = 0;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < k; j++) {
                if(matrix[i][j]==target){
                    return true;
                }
                if(matrix[i][j]>target){
                    k=j;
                    break;
                }
            }
        }
        return false;
    }
    @Test
    public void test(){
        int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,5));
    }
}
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}