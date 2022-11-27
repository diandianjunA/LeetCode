package FirstPackage;

import org.junit.Test;

import java.util.regex.Pattern;

public class MatchExpression {
    public boolean isMatch(String s, String p) {
        Pattern compile = Pattern.compile(p);
        return compile.matcher(s).matches();
    }
    public boolean isMatchMine(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0]=true;
        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if(p.charAt(j-1)=='*'){
                    if(compare(s.charAt(i-1),p.charAt(j-2))){
                        dp[i][j]=dp[i-1][j]||dp[i][j-2];
                    }else {
                        dp[i][j]=dp[i][j-2];
                    }
                }else{
                    if(compare(s.charAt(i-1),p.charAt(j-1))){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public boolean compare(char a,char b){
        if(b=='.'){
            return true;
        }
        return a==b;
    }
    public boolean isMatchPro(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    @Test
    public void test(){
        String s="acaabbaccbbacaabbbb";
        String p="a*.*b*.*a*aa*a*";
        System.out.println(isMatchMine(s,p));
    }
}
