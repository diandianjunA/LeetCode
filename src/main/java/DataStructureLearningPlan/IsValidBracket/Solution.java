package DataStructureLearningPlan.IsValidBracket;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            try {
                if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                    stack.push(s.charAt(i));
                }else if(stack.pop()!=map.get(s.charAt(i))){
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
