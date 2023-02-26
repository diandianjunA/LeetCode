package EveryDayExercise.LongestCommonPrefix;

import org.junit.Test;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        int j=0;
        while (j<strs[0].length()&&j<strs[1].length()&&strs[0].charAt(j)==strs[1].charAt(j)){
            stringBuilder.append(strs[0].charAt(j));
            j++;
        }
        for (int i = 2; i < strs.length; i++) {
            j=0;
            while (j<strs[i].length()&&j<stringBuilder.length()&&strs[i].charAt(j)==stringBuilder.charAt(j)){
                j++;
            }
            if(j<stringBuilder.length()){
                stringBuilder.delete(j,stringBuilder.length());
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test1(){
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    @Test
    public void test2(){
        String[] strs={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
