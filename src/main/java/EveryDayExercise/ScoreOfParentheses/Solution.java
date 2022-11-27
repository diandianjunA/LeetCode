package EveryDayExercise.ScoreOfParentheses;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int layer=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack1.push('(');
                layer++;
            }else{
                layer--;
                if(s.charAt(i-1)=='('){
                    map.put(layer,1+map.getOrDefault(layer,0));
                }else{
                    map.put(layer,2*map.getOrDefault(layer+1,0)+map.getOrDefault(layer,0));
                    map.remove(layer+1);
                }
            }
        }
        return map.get(0);
    }
    @Test
    public void test(){
        String parent="(()(()))";
        System.out.println(scoreOfParentheses(parent));
    }
    @Test
    public void test1(){
        String parent="(())()";
        System.out.println(scoreOfParentheses(parent));
    }
}
class Solution2{
    int i=0;
    public int K(String s)
    {
        int ans=0;
        while(s.charAt(i)!=')')
        {
            i++;
            ans+=K(s);
        }
        i++;
        if(ans==0) return 1;
        return 2*ans;
    }
    public int scoreOfParentheses(String s) {
        int ans=0;
        while(i<s.length())
        {
            i++;
            ans+=K(s);
        }
        return ans;
    }
}
class Solution3 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }
}
class Solution4 {
    public int scoreOfParentheses(String s) {
        int bal = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }
}