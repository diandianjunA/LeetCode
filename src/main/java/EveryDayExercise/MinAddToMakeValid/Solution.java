package EveryDayExercise.MinAddToMakeValid;

import org.junit.Test;

import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int index=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    index++;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.size()+index;
    }
    @Test
    public void test(){
        String s="(((";
        System.out.println(minAddToMakeValid(s));
    }
}
