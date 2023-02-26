package EveryDayExercise.AreNumbersAscending;

public class Solution {
    public boolean areNumbersAscending(String s) {
        int num=0;
        for (String s1 : s.split(" ")) {
            try {
                Integer.parseInt(s1);
            } catch (NumberFormatException e) {
                continue;
            }
            int i = Integer.parseInt(s1);
            if(i>num){
                num=i;
            }else{
                return false;
            }
        }
        return true;
    }
}
