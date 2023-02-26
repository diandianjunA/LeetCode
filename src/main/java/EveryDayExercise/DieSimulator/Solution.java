package EveryDayExercise.DieSimulator;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    static int mod=1000000007;
    public int dieSimulator(int n, int[] rollMax) {
        long res=0;
        for (int i = 1; i <= 6; i++) {
            res=(res+dfs(n,rollMax,1,1,i))%mod;
        }
        return (int) res;
    }

    public int dfs(int n,int[] rollMax,int p,int c,int pre){
        if(p>=n){
            return 1;
        }
        long res=0;
        for (int i = 1; i <=6 ; i++) {
            if(i==pre){
                if(rollMax[pre-1]>c){
                    res=(res+dfs(n,rollMax,p+1,c+1,i))%mod;
                }
            }else {
                res=(res+dfs(n,rollMax,p+1,1,i))%mod;
            }
        }
        return (int) res;
    }

    @Test
    public void test1(){
        int n=2;
        int[] rollMax={1,1,2,2,2,3};
        System.out.println(dieSimulator(n,rollMax));
    }

    @Test
    public void test2(){
        int n=2;
        int[] rollMax={1,1,1,1,1,1};
        System.out.println(dieSimulator(n,rollMax));
    }

    @Test
    public void test3(){
        int n=3;
        int[] rollMax={1,1,1,2,2,3};
        System.out.println(dieSimulator(n,rollMax));
    }

    @Test
    public void test4(){
        int n=20;
        int[] rollMax={8,5,10,8,7,2};
        System.out.println(dieSimulator(n,rollMax));
    }
}
class Solution2 {
    static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] d = new int[n + 1][6][16];
        for (int j = 0; j < 6; j++) {
            d[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int p = 0; p < 6; p++) {
                        if (p != j) {
                            d[i][p][1] = (d[i][p][1] + d[i - 1][j][k]) % MOD;
                        } else if (k + 1 <= rollMax[j]) {
                            d[i][p][k + 1] = (d[i][p][k + 1] + d[i - 1][j][k]) % MOD;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                res = (res + d[n][j][k]) % MOD;
            }
        }
        return res;
    }
}

class Solution3 {
    private static final long MOD = (long) 1e9 + 7;
    private int[] rollMax;
    private int[][][] cache;

    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax = rollMax;
        int m = rollMax.length;
        cache = new int[n][m][15];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; ++j)
                Arrays.fill(cache[i][j], -1); // -1 表示没有访问过
        long ans = 0;
        for (int j = 0; j < m; ++j)
            ans += dfs(n - 1, j, rollMax[j] - 1);
        return (int) (ans % MOD);
    }

    private int dfs(int i, int last, int left) {
        if (i == 0) return 1;
        if (cache[i][last][left] >= 0) return cache[i][last][left];
        long res = 0;
        for (int j = 0; j < rollMax.length; ++j)
            if (j != last) res += dfs(i - 1, j, rollMax[j] - 1);
            else if (left > 0) res += dfs(i - 1, j, left - 1);
        return cache[i][last][left] = (int) (res % MOD);
    }
}