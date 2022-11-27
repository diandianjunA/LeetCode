package EveryDayExercise.CustomSortString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String customSortString(String order, String s) {
        int[] orders = new int[26];
        int length=0;
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i)-'a']=i+1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(orders[s.charAt(i)-'a']!=0){
                length++;
            }
        }
        Character[] chars=new Character[length];
        int j=0;
        for (int i = 0; i < s.length(); i++) {
            if(orders[s.charAt(i)-'a']!=0){
                chars[j++]=s.charAt(i);
            }
        }
        Arrays.sort(chars,new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return orders[o1-'a']-orders[o2-'a'];
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        j=0;
        for (int i = 0; i < s.length(); i++) {
            if(orders[s.charAt(i)-'a']!=0){
                stringBuilder.append(chars[j++]);
            }else{
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test1(){
        String order="cba";
        String s="abcd";
        System.out.println(customSortString(order,s));
    }

    @Test
    public void test2(){
        String order="cbafg";
        String s="abcd";
        System.out.println(customSortString(order,s));
    }

    @Test
    public void test3(){
        String order="exv";
        String s="xwvee";
        System.out.println(customSortString(order,s));
    }
}
class Solution2 {
    public String customSortString(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}

class Solution3 {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            ++freq[ch - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return ans.toString();
    }
}