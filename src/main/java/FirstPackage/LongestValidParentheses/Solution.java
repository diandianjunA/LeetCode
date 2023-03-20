package FirstPackage.LongestValidParentheses;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int[] help = new int[s.length()];
        Arrays.fill(help,1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    Integer pop = stack.pop();
                    help[pop]=0;
                    help[i]=0;
                }
            }
        }
        int max=0;
        int cur=0;
        for (int i = 0; i < help.length; i++) {
            if(help[i]==0){
                cur++;
            }else{
                if(cur>max){
                    max=cur;
                }
                cur=0;
            }
        }
        return Math.max(cur,max);
    }

    @Test
    public void test1(){
        String s="(()";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void test2(){
        String s=")()())";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void test3(){
        String s="";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void test4(){
        String s="()(()";
        System.out.println(longestValidParentheses(s));
    }
}
