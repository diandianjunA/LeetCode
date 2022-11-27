package EveryDayExercise;

import org.junit.Test;

import java.util.Arrays;

public class MaxLengthBetweenEqualCharacters {
    //我的解法
    //执行用时：4 ms, 在所有 Java 提交中击败了18.31%的用户
    //内存消耗：41.6 MB, 在所有 Java 提交中击败了5.03%的用户
    //通过测试用例：54 / 54
    public int maxLengthBetweenEqualCharacters(String s) {
        String temp=s;
        int index=0;
        int length = s.length();
        int maxLength=-1;
        while(index<length){
            temp=s.substring(index+1);
            if(temp.contains(s.substring(index,index+1))){
                int lastIndex=temp.length()-1;
                while(temp.charAt(lastIndex)!=s.charAt(index)){
                    lastIndex--;
                }
                if(lastIndex>maxLength){
                    maxLength=lastIndex;
                }
            }
            index++;
        }
        return maxLength;
    }
    //大佬解法
    public int maxLengthBetweenEqualCharactersPro(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                maxLength = Math.max(maxLength, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLength;
    }
    @Test
    public void test(){
        String s="mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
}
