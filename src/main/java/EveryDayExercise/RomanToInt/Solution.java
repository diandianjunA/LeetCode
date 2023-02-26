package EveryDayExercise.RomanToInt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('I');
        list.add('V');
        list.add('X');
        list.add('L');
        list.add('C');
        list.add('D');
        list.add('M');
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        int i = 0;
        for (; i < s.length()-1; i++) {
            if(list.indexOf(s.charAt(i))>=list.indexOf(s.charAt(i+1))){
                res=res+map.get(s.charAt(i));
            }else{
                res=res+map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i++;
            }
        }
        if(i<s.length()){
            res=res+map.get(s.charAt(i));
        }
        return res;
    }

    @Test
    public void test1(){
        String s="III";
        System.out.println(romanToInt(s));
    }

    @Test
    public void test2(){
        String s="IV";
        System.out.println(romanToInt(s));
    }

    @Test
    public void test3(){
        String s="IX";
        System.out.println(romanToInt(s));
    }

    @Test
    public void test4(){
        String s="LVIII";
        System.out.println(romanToInt(s));
    }

    @Test
    public void test5(){
        String s="MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
