package EveryDayExercise.CountConsistentStrings;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res=0;
        boolean flag=true;
        for (int i = 0; i < words.length; i++) {
            flag=true;
            for (int j = 0; j < words[i].length(); j++) {
                if(!allowed.contains(words[i].charAt(j)+"")){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res++;
            }
        }
        return res;
    }
}
class Solution2 {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}