package EveryDayExercise.ParseBoolExpr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean parseBoolExpr(String expression) {
        switch (expression.charAt(0)){
            case 't': return true;
            case 'f': return false;
            case '!': return !parseBoolExpr(expression.substring(2,expression.length()-1));
            case '&':
                String substring = expression.substring(2, expression.length() - 1);
                boolean res=true;
                for (String s : split(substring)) {
                    res=res&&parseBoolExpr(s);
                }
                return res;
            case '|':
                substring = expression.substring(2, expression.length() - 1);
                substring = expression.substring(2, expression.length() - 1);
                res = false;
                for (String s : split(substring)) {
                    res=res||parseBoolExpr(s);
                }
                return res;
        }
        return false;
    }
    public List<String> split(String s){
        int layer=0;
        int pre=0;
        ArrayList<String> splits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==','&&layer==0){
                splits.add(s.substring(pre,i));
                pre=i+1;
            }else if(s.charAt(i)=='('){
                layer++;
            } else if (s.charAt(i) == ')') {
                layer--;
            }
        }
        splits.add(s.substring(pre));
        return splits;
    }

    @Test
    public void test1(){
        String expression="!(f)";
        System.out.println(parseBoolExpr(expression));
    }

    @Test
    public void test2(){
        String expression="|(f,t)";
        System.out.println(parseBoolExpr(expression));
    }

    @Test
    public void test3(){
        String expression="&(t,f)";
        System.out.println(parseBoolExpr(expression));
    }

    @Test
    public void test4(){
        String expression="|(&(t,f,t),!(t))";
        System.out.println(parseBoolExpr(expression));
    }
}
