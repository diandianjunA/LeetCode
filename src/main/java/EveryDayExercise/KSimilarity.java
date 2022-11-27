package EveryDayExercise;

import org.junit.Test;

//854题
public class KSimilarity {
    public int kSimilarity(String s1, String s2) {
        int k=0;
        byte[] str1 = s1.getBytes();
        byte[] str2 = s2.getBytes();
        return getTimes(str1,str2,0,0);
    }
    public int getTimes(byte[] s1,byte[] s2,int index,int k){
        if(index==s1.length-1){
            return k;
        } else if (s1[index]==s2[index]) {
            return getTimes(s1,s2,index+1,k);
        }else{
            k++;
            int minK=Integer.MAX_VALUE;
            for (int i = s2.length-1; i >=index; i--) {
                if(s2[i]!=s1[index]){
                    continue;
                }
                if(s2[index]==s1[i]){
                    byte temp=s2[i];
                    s2[i]=s2[index];
                    s2[index]=temp;
                    return getTimes(s1,s2,index+1,k);
                }
                String s = new String(s2);
                byte[] temps = s.getBytes();
                byte temp=temps[i];
                temps[i]=temps[index];
                temps[index]=temp;
                int times = getTimes(s1, temps, index + 1, k);
                if(times<minK){
                    minK=times;
                }
            }
            return minK;
        }
    }
    @Test
    public void test(){
        String s1="baaabaabbbabbbabaaab";
        String s2="babbbbbaabaabaaaabba";
        System.out.println(kSimilarity(s1,s2));
    }
}
class Solution {
    int result = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
        return execute(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int execute(char[] sc1, char[] sc2, int start, int current) {
        if (current >= result) return result; // 如果交换次数已经超过"目前最小交换次数result"，终止递归
        if (start == sc1.length - 1) return result = Math.min(current, result);

        for (int i = start; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) {
                for (int j = i + 1; j < sc2.length; j++) {
                    if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
                        swap(sc2, i, j); // 交换
                        execute(sc1, sc2, i + 1, current + 1);
                        swap(sc2, i, j); // 回溯
                        if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return result;
            }
        }
        return result = Math.min(current, result);
    }

    public void swap(char[] sc, int i, int j){
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }
}
class SolutionBFS {
    int ans = 0x3f3f3f3f;

    public int kSimilarity(String s1, String s2) {
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    private int dfs(char[] c1, char[] c2, int idx, int steps) {
        // 优化剪枝，当前交换次数比已经得到的最小交换次数大
        if (steps >= ans) return ans;
        if (idx == c1.length - 1) return ans = Math.min(ans, steps);
        int i = idx;
        while (i < c1.length) {
            // 找到第一个不同的字母，进行交换
            if (c1[i] != c2[i]) {
                for (int j = i + 1; j < c1.length; j++) {
                    if (c1[j] == c2[i]) {
                        swap(c1, i, j);
                        dfs(c1, c2, idx, steps + 1);
                        swap(c1, j, i);
                    }
                }
                return ans;
            }
            i++;
        }
        return ans = Math.min(ans, steps);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}