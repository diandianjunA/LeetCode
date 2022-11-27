package EveryDayExercise.LetterCasePermutation;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        res.add(s);
        solve(res,s,0);
        return res;
    }
    public void solve(List<String> res,String s,int index){
        if(index>=s.length()){
            return;
        }
        if(s.charAt(index)>='a'&&s.charAt(index)<='z'){
            String replace = s.substring(0, index) + (s.charAt(index) + "").toUpperCase() + s.substring(index + 1);
            res.add(replace);
            solve(res,replace,index+1);
            solve(res,s,index+1);
        } else if (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') {
            String replace = s.substring(0, index) + (s.charAt(index) + "").toLowerCase() + s.substring(index + 1);
            res.add(replace);
            solve(res,replace,index+1);
            solve(res,s,index+1);
        }else{
            solve(res, s, index+1);
        }
    }
    @Test
    public void test1(){
        String s="a1b2";
        for (String s1 : letterCasePermutation(s)) {
            System.out.println(s1);
        }
    }
}
class Solution2 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        Queue<StringBuilder> queue = new ArrayDeque<StringBuilder>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                ans.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }
        return ans;
    }
}
class Solution3 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    public void dfs(char[] arr, int pos, List<String> res) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
    }
}
class Solution4 {
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i))) {
                m++;
            }
        }
        List<String> ans = new ArrayList<String>();
        for (int mask = 0; mask < (1 << m); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = 0; j < n; j++) {
                if (Character.isLetter(s.charAt(j)) && (mask & (1 << k++)) != 0) {
                    sb.append(Character.toUpperCase(s.charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(j)));
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}