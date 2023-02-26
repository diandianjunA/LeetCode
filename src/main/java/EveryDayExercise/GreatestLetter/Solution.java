package EveryDayExercise.GreatestLetter;

public class Solution {
    public String greatestLetter(String s) {
        boolean[] great = new boolean[26];
        boolean[] small = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                small[s.charAt(i)-'a']=true;
            }else{
                great[s.charAt(i)-'A']=true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if(small[i]&&great[i]){
                char c= (char) (i+'A');
                return c+"";
            }
        }
        return "";
    }
}
