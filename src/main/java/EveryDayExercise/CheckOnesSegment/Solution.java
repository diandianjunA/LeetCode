package EveryDayExercise.CheckOnesSegment;

import org.junit.Test;

public class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag=true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                if(flag){
                    while (i<s.length()&&s.charAt(i)=='1'){
                        i++;
                    }
                    flag=false;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        String s="110";
        System.out.println(checkOnesSegment(s));
    }
}
class Solution2 {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}