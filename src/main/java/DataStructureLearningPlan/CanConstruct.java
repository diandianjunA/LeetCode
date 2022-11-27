package DataStructureLearningPlan;

import org.junit.Test;

import java.util.ArrayList;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < magazine.length(); i++) {
            list.add(magazine.charAt(i));
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(list.contains(ransomNote.charAt(i))){
                list.remove(list.indexOf(ransomNote.charAt(i)));
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean canConstructPro(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        String ransomNote="aa";
        String magazine="ab";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
