package WeekCompetition336.VowelStrings;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int res=0;
        for (int i = left; i <= right; i++) {
            if(list.contains(words[i].charAt(0))&&list.contains(words[i].charAt(words[i].length()-1))){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String[] words={"are","amy","u"};
        int left=0;
        int right=2;
        System.out.println(vowelStrings(words,left,right));
    }

    @Test
    public void test2(){
        String[] words={"hey","aeo","mu","ooo","artro"};
        int left=1;
        int right=4;
        System.out.println(vowelStrings(words,left,right));
    }
}
