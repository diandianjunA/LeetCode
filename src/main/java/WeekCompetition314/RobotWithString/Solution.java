package WeekCompetition314.RobotWithString;

import org.junit.Test;

import java.util.*;
//本题是经典贪心：求出栈序列的最小字典序。
//
//我们首先将题目描述进行转化：有一个初始为空的栈，给定字符的入栈顺序，求字典序最小的出栈序列。
//
//当一个字符入栈后，我们持续检查栈顶元素 cc。设还未入栈的字符中，字典序最小的字符是 mm，有以下两种情况。
//
//c≤m：此时弹出c最优。如果此时按兵不动，下一个出栈的将会是大等于 cc 的字符，答案不会变优。
//c>m：此时不弹出c，等待后续更小的字符入栈。
//所有字符都入栈后，栈内的剩余字符按顺序弹出即可。
//
public class Solution {
    public String robotWithString(String s) {
        char[] min = new char[s.length()];
        char minCharacter='z';
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)<minCharacter){
                minCharacter=s.charAt(i);
            }
            min[i]=minCharacter;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty()&&stack.peek()<=min[i]){
                res.append(stack.pop());
            }
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
    @Test
    public void test(){
        String s="zza";
        System.out.println(robotWithString(s));
    }
    @Test
    public void test1(){
        String s="bac";
        System.out.println(robotWithString(s));
    }
    @Test
    public void test2(){
        String s="bdda";
        System.out.println(robotWithString(s));
    }
    @Test
    public void test3(){
        String s="bydizfve";
        System.out.println(robotWithString(s));
    }
    @Test
    public void test4(){
        String s="vzhofnpo";
        System.out.println(robotWithString(s));
    }
    @Test
    public void test5(){
        String s="mmuqezwmomeplrtskz";
        System.out.println(robotWithString(s));
    }
}
