package FirstPackage;

import org.junit.Test;

import java.util.HashSet;

public class TheLongestSubstring {
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    class Solution {
        //我的解法
        //执行用时：73 ms, 在所有 Java 提交中击败了11.45%的用户
        //内存消耗：42 MB, 在所有 Java 提交中击败了14.88%的用户
        //通过测试用例：987 / 987
        public int lengthOfLongestSubstring(String s) {
            int max=0;
            int len;
            int j=0;
            HashSet<Character> characters = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                len=characters.size();
                characters.add(s.charAt(i));
                if(len==characters.size()){
                    if(len>max){
                        max=len;
                    }
                    characters.clear();
                    i=j;
                    j=i+1;
                }
            }
            len=characters.size();
            if(len>max){
                max=len;
            }
            return max;
        }
        //大佬解法
        public int lengthOfLongestSubStringPro(String s){
            // 记录字符上一次出现的位置
            int[] last = new int[128];
//        for(int i = 0; i < 128; i++) {
//            last[i] = -1;
//        }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index]);
                res   = Math.max(res, i - start + 1);
                last[index] = i+1;
            }

            return res;
        }
    }
    @Test
    public void Test(){
        String str="dvdf";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
}
