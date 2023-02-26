package EveryDayExercise.RearrangeCharacters;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public int rearrangeCharacters(String s, String target) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(target.contains(s.charAt(i)+"")){
                list.add(s.charAt(i));
            }
        }
        int res=0;
        while(!list.isEmpty()){
            for (int i = 0; i < target.length(); i++) {
                if(list.contains(target.charAt(i))){
                    list.remove(list.indexOf(target.charAt(i)));
                }else{
                    return res;
                }
            }
            res++;
        }
        return res;
    }
}
class Solution2 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCounts = new HashMap<Character, Integer>();
        Map<Character, Integer> targetCounts = new HashMap<Character, Integer>();
        int n = s.length(), m = target.length();
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (targetCounts.containsKey(c)) {
                sCounts.put(c, sCounts.getOrDefault(c, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            int totalCount = sCounts.containsKey(c) ? sCounts.get(c) : 0;
            ans = Math.min(ans, totalCount / count);
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }
}