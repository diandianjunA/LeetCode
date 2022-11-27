package EveryDayExercise.Interpret;

import java.util.Stack;

public class Solution {
    public String interpret(String command) {
        Stack<Character> stringStack = new Stack<>();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)){
                case 'G':
                    stringBuilder.append("G");
                    break;
                case '(':
                    stringStack.push(command.charAt(i));
                    break;
                case ')':
                    if(stringStack.peek()=='('){
                        stringStack.pop();
                        stringBuilder.append("o");
                    }else{
                        while(stringStack.peek()!='('){
                            stringStack.pop();
                        }
                        stringStack.pop();
                        stringBuilder.append("al");
                    }
                    break;
                default:
                    stringStack.push(command.charAt(i));
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
