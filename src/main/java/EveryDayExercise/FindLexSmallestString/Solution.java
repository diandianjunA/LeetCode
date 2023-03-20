package EveryDayExercise.FindLexSmallestString;

import org.junit.Test;

import java.util.*;

public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> list = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        String min=s;
        while(!queue.isEmpty()){
            String poll = queue.poll();
            String s1 = operationA(poll, a);
            String s2 = operationB(poll, b);
            if(!list.contains(s1)){
                list.add(s1);
                queue.add(s1);
                if(!compare(min,s1)){
                    min=s1;
                }
            }
            if(!list.contains(s2)){
                list.add(s2);
                queue.add(s2);
                if(!compare(min,s2)){
                    min=s2;
                }
            }
        }
        return min;
    }

    public String operationA(String s,int a){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                stringBuilder.append(s.charAt(i));
            }else{
                int t=(s.charAt(i)-'0'+a)%10;
                char c= (char) (t+'0');
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String operationB(String s,int b){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-b; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < s.length() - b; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
    
    public boolean compare(String s1,String s2){
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)<s2.charAt(i)){
                return true;
            }else if(s1.charAt(i)>s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        String s="5525";
        int a=9;
        int b=2;
        System.out.println(findLexSmallestString(s,a,b));
    }

    @Test
    public void test2(){
        String s="74";
        int a=5;
        int b=1;
        System.out.println(findLexSmallestString(s,a,b));
    }

    @Test
    public void test3(){
        String s="0011";
        int a=4;
        int b=2;
        System.out.println(findLexSmallestString(s,a,b));
    }

    @Test
    public void test4(){
        String s="43987654";
        int a=7;
        int b=3;
        System.out.println(findLexSmallestString(s,a,b));
    }

    @Test
    public void test5(){
        String s="2873271602311831203580959577866799570924135996506341705025210845731958152268255729963747";
        int a=3;
        int b=39;
        System.out.println(findLexSmallestString(s,a,b));
    }
}
