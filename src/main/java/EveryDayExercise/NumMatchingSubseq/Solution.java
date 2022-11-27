package EveryDayExercise.NumMatchingSubseq;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res=0;
        HashMap<String,Integer> hashSet = new HashMap<>();
        for (String value : words) {
            hashSet.put(value, hashSet.getOrDefault(value, 0) + 1);
        }
        for (String word : hashSet.keySet()) {
            int k=0;
            int j=0;
            int flag=0;
            for (j = 0; j < word.length()&&k<s.length(); j++,k++) {
                if(s.charAt(k)!=word.charAt(j)){
                    while(k<s.length()&&s.charAt(k)!=word.charAt(j)){
                        k++;
                    }
                    if(k!=s.length()){
                        flag++;
                    }
                }else{
                    flag++;
                }
            }
            if(flag==word.length()){
                res=res+hashSet.get(word);
            }
        }
        return res;
    }
    @Test
    public void test1(){
        String s="abcde";
        String[] words={"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s,words));
    }
    @Test
    public void test2(){
        String s="dsahjpjauf";
        String[] words={"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s,words));
    }
}
class Solution2 {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
class Solution3 {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] p = new Queue[26];
        for (int i = 0; i < 26; ++i) {
            p[i] = new ArrayDeque<int[]>();
        }
        for (int i = 0; i < words.length; ++i) {
            p[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int len = p[c - 'a'].size();
            while (len > 0) {
                int[] t = p[c - 'a'].poll();
                if (t[1] == words[t[0]].length() - 1) {
                    ++res;
                } else {
                    ++t[1];
                    p[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                --len;
            }
        }
        return res;
    }
}