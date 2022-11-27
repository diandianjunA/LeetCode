package EveryDayExercise.ExpressiveWords;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int expressiveWords(String s, String[] words) {
        HashMap<Integer, List<Integer>> listHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); ) {
            int num=1;
            char a=s.charAt(i);
            ArrayList<Integer> list = new ArrayList<>();
            while (i+num<s.length()&&s.charAt(i+num)==a){
                num++;
            }
            switch (num){
                case 1:
                    list.add(1);
                    break;
                case 2:
                    list.add(2);
                    break;
                default:
                    for (int j = num; j >= 1; j--) {
                        list.add(j);
                    }
                    break;
            }
            listHashMap.put(i,list);
            i=i+num;
        }
        int res=0;
        for (int i = 0; i < words.length; i++) {
            int k=0;
            boolean flag=true;
            for (int j = 0; j < words[i].length(); ) {
                int num=1;
                char a=words[i].charAt(j);
                while (j+num<words[i].length()&&words[i].charAt(j+num)==a){
                    num++;
                }
                if(k==s.length()||words[i].charAt(j)!=s.charAt(k)||!listHashMap.get(k).contains(num)){
                    flag=false;
                    break;
                }
                k=k+listHashMap.get(k).get(0);
                j=j+num;
            }
            if(flag&&k==s.length()){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String s="heeellooo";
        String[] words={"hello","hi","helo"};
        System.out.println(expressiveWords(s,words));
    }

    @Test
    public void test2(){
        String s="abcd";
        String[] words={"abc"};
        System.out.println(expressiveWords(s,words));
    }

    @Test
    public void test3(){
        String s="heeellooo";
        String[] words={"heeelloooworld"};
        System.out.println(expressiveWords(s,words));
    }
}
