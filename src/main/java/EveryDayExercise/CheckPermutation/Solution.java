package EveryDayExercise.CheckPermutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.charAt(i));
        }
        try {
            for (int i = 0; i < s2.length(); i++) {
                list.remove(list.indexOf(s2.charAt(i)));
            }
        } catch (Exception e) {
            return false;
        }
        if(list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void test(){
        String s1="abc";
        String s2="bca";
        System.out.println(CheckPermutation(s1,s2));
    }
}
//类哈希表的思路
class Solution2 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i)]--;
            if (table[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
//排序
class Solution3 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}