package EveryDayExercise.BraceExpansionII;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<String> braceExpansionII(String expression) {
        List<String> deal = deal(expression, 0);
        HashSet<String> set = new HashSet<>(deal);
        ArrayList<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    public List<String> deal(String expression,int i){
        if(i>=expression.length()){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        while(i<expression.length()&&expression.charAt(i)!=','){
            if(expression.charAt(i)=='{'){
                int begin=++i;
                Stack<Character> stack = new Stack<>();
                stack.push('{');
                while(!stack.isEmpty()){
                    if(expression.charAt(i)=='{'){
                        stack.push('{');
                    } else if (expression.charAt(i) == '}') {
                        stack.pop();
                    }
                    i++;
                }
                List<String> deal = deal(expression.substring(begin, i - 1), 0);
                if(deal!=null){
                    ArrayList<String> strings = new ArrayList<>();
                    for(String s:list){
                        for (String s1:deal){
                            strings.add(s+s1);
                        }
                    }
                    list=strings;
                }
            }else {
                ArrayList<String> strings = new ArrayList<>();
                for(String s:list){
                    strings.add(s+expression.charAt(i));
                }
                list=strings;
                i++;
            }
        }
        List<String> deal = deal(expression, i + 1);
        if(deal!=null){
            list.addAll(deal);
        }
        return list;
    }

    @Test
    public void test1(){
        String expression="{a,b}{c,{d,e}}";
        System.out.println(braceExpansionII(expression));
    }

    @Test
    public void test2(){
        String expression="{{a,z},a{b,c},{ab,z}}";
        System.out.println(braceExpansionII(expression));
    }

    @Test
    public void test3(){
        String expression="{a,b}{c,{d,e}}";
        System.out.println(braceExpansionII(expression));
    }
}
