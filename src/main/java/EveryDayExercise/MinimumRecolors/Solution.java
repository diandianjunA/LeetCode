package EveryDayExercise.MinimumRecolors;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wNum=0;
        int bNum=0;
        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i)=='W'){
                wNum++;
            }else {
                bNum++;
            }
        }
        if(wNum==0){
            return 0;
        }
        int min=wNum;
        for (int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i-k)=='W'){
                wNum--;
            }else {
                bNum--;
            }
            if(blocks.charAt(i)=='W'){
                wNum++;
            }else {
                bNum++;
            }
            min=Math.min(min,wNum);
            if(min==0){
                return 0;
            }
        }
        return min;
    }

    @Test
    public void test1(){
        String block="WBBWWBBWBW";
        int k=7;
        System.out.println(minimumRecolors(block,k));
    }

    @Test
    public void test2(){
        String block="WBWBBBW";
        int k=2;
        System.out.println(minimumRecolors(block,k));
    }
}
