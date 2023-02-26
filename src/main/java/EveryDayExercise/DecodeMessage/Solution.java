package EveryDayExercise.DecodeMessage;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        Arrays.fill(map,'0');
        int j=0;
        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i)!=' '&& map[key.charAt(i)-'a']=='0'){
                map[key.charAt(i) - 'a'] = (char) (j+'a');
                j++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i)!=' '){
                stringBuilder.append(map[message.charAt(i)-'a']);
            }else {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test1(){
        String key="the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key,message));
    }

    @Test
    public void test2(){
        String key="eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key,message));
    }
}
