package FirstPackage.FindSubstring;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int length=words[0].length()*words.length;
        ArrayList<String> list = new ArrayList<>(List.of(words));
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j < words[0].length(); j++) {
            if(j+length>s.length()){
                break;
            }
            HashMap<String, Integer> basket = new HashMap<>();
            for (int i = j; i < length+j; i=i+words[0].length()) {
                String substring = s.substring(i, i + words[0].length());
                basket.put(substring,basket.getOrDefault(substring,0)+1);
            }
            for (int i = 0; i < words.length; i++) {
                basket.put(words[i],basket.getOrDefault(words[i],0)-1);
                if(basket.get(words[i])==0){
                    basket.remove(words[i]);
                }
            }
            if(basket.isEmpty()&&!res.contains(j)){
                res.add(j);
            }
            for (int i = j+words[0].length(); i < s.length()-length+1; i=i+words[0].length()) {
                String substring1 = s.substring(i - words[0].length(), i);
                basket.put(substring1,basket.getOrDefault(substring1,0)-1);
                if(basket.get(substring1)==0){
                    basket.remove(substring1);
                }
                String substring2 = s.substring(i + length - words[0].length(), i + length);
                basket.put(substring2,basket.getOrDefault(substring2,0)+1);
                if (basket.get(substring2)==0){
                    basket.remove(substring2);
                }
                if(basket.isEmpty()&&!res.contains(i)){
                    res.add(i);
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        String s="barfoothefoobarman";
        String[] words={"foo","bar"};
        System.out.println(findSubstring(s,words));
    }

    @Test
    public void test2(){
        String s="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","word"};
        System.out.println(findSubstring(s,words));
    }

    @Test
    public void test3(){
        String s="barfoofoobarthefoobarman";
        String[] words={"bar","foo","the"};
        System.out.println(findSubstring(s,words));
    }

    @Test
    public void test4(){
        String s="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","good"};
        System.out.println(findSubstring(s,words));
    }

    @Test
    public void test5(){
        String s="lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words={"fooo","barr","wing","ding","wing"};
        System.out.println(findSubstring(s,words));
    }
}
