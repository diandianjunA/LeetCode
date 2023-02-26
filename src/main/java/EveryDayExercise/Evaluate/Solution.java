package EveryDayExercise.Evaluate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair:knowledge){
            map.put(pair.get(0),pair.get(1));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='('){
                res.append(s.charAt(i));
            }else{
                i++;
                while(s.charAt(i)!=')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                res.append(map.getOrDefault(temp.toString(),"?"));
                temp.delete(0,temp.length());
            }
        }
        return res.toString();
    }

    @Test
    public void test1(){
        String s="(name)is(age)yearsold";
        List<List<String>> lists = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        strings1.add("name");
        strings1.add("bob");
        strings2.add("age");
        strings2.add("two");
        lists.add(strings1);
        lists.add(strings2);
        System.out.println(evaluate(s,lists));
    }
}
