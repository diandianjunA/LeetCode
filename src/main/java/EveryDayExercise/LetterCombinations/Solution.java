package EveryDayExercise.LetterCombinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        HashMap<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r','s'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y','z'});
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (char c : map.get(digits.charAt(0) - '0')) {
            StringBuilder stringBuilder = new StringBuilder(c+"");
            list1.add(stringBuilder.toString());
        }
        for (int i = 1; i < digits.length(); i++) {
            if(list1.isEmpty()){
                for(String s:list2){
                    for (char c : map.get(digits.charAt(i) - '0')) {
                        StringBuilder stringBuilder = new StringBuilder(s);
                        stringBuilder.append(c);
                        list1.add(stringBuilder.toString());
                    }
                }
                list2.clear();
            }else{
                for(String s:list1){
                    for (char c : map.get(digits.charAt(i) - '0')) {
                        StringBuilder stringBuilder = new StringBuilder(s);
                        stringBuilder.append(c);
                        list2.add(stringBuilder.toString());
                    }
                }
                list1.clear();
            }
        }
        if(list1.isEmpty()){
            return list2;
        }else {
            return list1;
        }
    }

    @Test
    public void test1(){
        String digits="23";
        System.out.println(letterCombinations(digits));
    }
}
