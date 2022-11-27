package EveryDayExercise.RotatedDigits;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int rotatedDigits(int n) {
        if(n==1){
            return 0;
        }
        String str=n+"";
        if(str.contains("3")||str.contains("4")||str.contains("7")){
            return rotatedDigits(n-1);
        } else if (!str.contains("2") && !str.contains("5") && !str.contains("6") && !str.contains("9")) {
            return rotatedDigits(n-1);
        }else {
            return 1+rotatedDigits(n-1);
        }
    }
    @Test
    public void test(){
        System.out.println(rotatedDigits(20));
    }
}
class Solution2 {
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); ++j) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ++ans;
            }
        }
        return ans;
    }
}
class Solution3 {
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    int[][][] memo = new int[5][2][2];
    List<Integer> digits = new ArrayList<Integer>();

    public int rotatedDigits(int n) {
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 2; ++j) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int ans = dfs(0, 1, 0);
        return ans;
    }

    public int dfs(int pos, int bound, int diff) {
        if (pos == digits.size()) {
            return diff;
        }
        if (memo[pos][bound][diff] != -1) {
            return memo[pos][bound][diff];
        }

        int ret = 0;
        for (int i = 0; i <= (bound != 0 ? digits.get(pos) : 9); ++i) {
            if (check[i] != -1) {
                ret += dfs(
                        pos + 1,
                        bound != 0 && i == digits.get(pos) ? 1 : 0,
                        diff != 0 || check[i] == 1 ? 1 : 0
                );
            }
        }
        return memo[pos][bound][diff] = ret;
    }
}
class Solution4 {
    static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    char s[];
    int dp[][];

    public int rotatedDigits(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][2];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    int f(int i, int hasDiff, boolean isLimit) {
        if (i == s.length) return hasDiff; // 只有包含 2/5/6/9 才算一个好数
        if (!isLimit && dp[i][hasDiff] >= 0) return dp[i][hasDiff];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; ++d) // 枚举要填入的数字 d
            if (DIFFS[d] != -1) // d 不是 3/4/7
                res += f(i + 1, hasDiff | DIFFS[d], isLimit && d == up);
        if (!isLimit) dp[i][hasDiff] = res;
        return res;
    }
}

class Solution5 {
    private int[] a = new int[6];
    private int[][] dp = new int[6][2];

    public int rotatedDigits(int n) {
        int len = 0;
        for (int[] e : dp) {
            Arrays.fill(e, -1);
        }
        while (n > 0) {
            a[++len] = n % 10;
            n /= 10;
        }
        return dfs(len, 0, true);
    }

    private int dfs(int pos, int ok, boolean limit) {
        if (pos <= 0) {
            return ok;
        }
        if (!limit && dp[pos][ok] != -1) {
            return dp[pos][ok];
        }
        int up = limit ? a[pos] : 9;
        int ans = 0;
        for (int i = 0; i <= up; ++i) {
            if (i == 0 || i == 1 || i == 8) {
                ans += dfs(pos - 1, ok, limit && i == up);
            }
            if (i == 2 || i == 5 || i == 6 || i == 9) {
                ans += dfs(pos - 1, 1, limit && i == up);
            }
        }
        if (!limit) {
            dp[pos][ok] = ans;
        }
        return ans;
    }
}