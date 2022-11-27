package EveryDayExercise.AmbiguousCoordinate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> ambiguousCoordinates(String s){
        ArrayList<String> res = new ArrayList<>();
        String primary = s.substring(1, s.length() - 1);
        for (int i = 1; i < primary.length(); i++) {
            List<String> first = getRightNumber(primary.substring(0, i));
            List<String> second = getRightNumber(primary.substring(i));
            for (String str1 : first) {
                for (String str2 : second) {
                    res.add("("+str1+", "+str2+")");
                }
            }
        }
        return res;
    }

    public List<String> getRightNumber(String s){
        ArrayList<String> res = new ArrayList<>();
        if(s.charAt(0)!='0'){
            res.add(s);
            if(s.charAt(s.length()-1)!='0'){
                for (int i = 1; i < s.length(); i++) {
                    res.add(s.substring(0,i)+"."+s.substring(i));
                }
            }
        }else{
            if(s.length()==1){
                res.add("0");
            }else if(s.charAt(s.length()-1)!='0'){
                res.add("0."+s.substring(1));
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String s="(123)";
        List<String> strings = ambiguousCoordinates(s);
        System.out.println(strings);
    }

    @Test
    public void test2(){
        String s="(00011)";
        List<String> strings = ambiguousCoordinates(s);
        System.out.println(strings);
    }

    @Test
    public void test3(){
        String s="(0123)";
        List<String> strings = ambiguousCoordinates(s);
        System.out.println(strings);
    }

    @Test
    public void test4(){
        String s="(0110)";
        List<String> strings = ambiguousCoordinates(s);
        System.out.println(strings);
    }
}
