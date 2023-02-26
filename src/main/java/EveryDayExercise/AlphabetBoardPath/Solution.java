package EveryDayExercise.AlphabetBoardPath;

import org.junit.Test;

import java.util.HashMap;

public class Solution {
    public String alphabetBoardPath(String target) {
        HashMap<Character, int[]> map = new HashMap<>();
        int x=0;
        int y=0;
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a'+i),new int[]{x,y});
            y++;
            if(y>=5){
                x++;
                y=0;
            }
        }
        char pre='a';
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int[] from = map.get(pre);
            int[] to = map.get(target.charAt(i));
            int row=from[0]-to[0];
            int col=from[1]-to[1];
            if(target.charAt(i)=='z'){
                if(col<0){
                    res.append("R".repeat(Math.max(0, -col)));
                }else {
                    res.append("L".repeat(col));
                }
                if(row<0){
                    res.append("D".repeat(Math.max(0, -row)));
                }else {
                    res.append("U".repeat(row));
                }
            }else {
                if(row<0){
                    res.append("D".repeat(Math.max(0, -row)));
                }else {
                    res.append("U".repeat(row));
                }
                if(col<0){
                    res.append("R".repeat(Math.max(0, -col)));
                }else {
                    res.append("L".repeat(col));
                }
            }
            res.append("!");
            pre=target.charAt(i);
        }
        return res.toString();
    }

    @Test
    public void test1(){
        String target="leet";
        System.out.println(alphabetBoardPath(target));
    }

    @Test
    public void test2(){
        String target="code";
        System.out.println(alphabetBoardPath(target));
    }

    @Test
    public void test3(){
        String target="zdz";
        System.out.println(alphabetBoardPath(target));
    }
}
