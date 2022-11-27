package EveryDayExercise.Decrypt;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k==0){
            Arrays.fill(code, 0);
            return code;
        }
        int[] arr = new int[code.length];
        if(k>0){
            for (int i = 0; i < code.length; i++) {
                int num=0;
                for (int j = i+1; j <= i+k; j++) {
                    num=num+code[j%code.length];
                }
                arr[i]=num;
            }
        }else{
            for (int i = 0; i < code.length; i++) {
                int num=0;
                for (int j = i-1; j >= i+k; j--) {
                    num=num+code[(j+code.length)%code.length];
                }
                arr[i]=num;
            }
        }
        return arr;
    }
    @Test
    public void test(){
        int[] arr={2,4,9,3};
        System.out.println(Arrays.toString(Solution3.decrypt(arr,-2)));
    }
}
//滑动窗口
class Solution2 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }
        return res;
    }
}
//自我改进
class Solution3{
    public static int[] decrypt(int[] code, int k) {
        if(k==0){
            Arrays.fill(code, 0);
            return code;
        }
        int[] arr = new int[code.length];
        if(k>0){
            int sum=0;
            for (int i = 0; i < k; i++) {
                sum+=code[i];
            }
            for (int i = 0; i < code.length; i++) {
                sum=sum-code[i]+code[(i+k)%code.length];
                arr[i]=sum;
            }
        }else{
            int sum=0;
            for (int i = -1; i >k-1; i--) {
                sum+=code[(i+code.length)%code.length];
            }
            for (int i = 0; i < code.length; i++) {
                arr[i]=sum;
                sum=sum+code[i]-code[(i+k+code.length)%code.length];
            }
        }
        return arr;
    }
}