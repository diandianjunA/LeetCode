package EveryDayExercise.BoxMinOperations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] minOperations(String boxes) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i)=='1'){
                list.add(i);
            }
        }
        int[] res = new int[boxes.length()];
        for (int i = 0; i < res.length; i++) {
            int move=0;
            for(Integer e:list){
                move=move+Math.abs(i-e);
            }
            res[i]=move;
        }
        return res;
    }

    @Test
    public void test1(){
        String boxes="110";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    @Test
    public void test2(){
        String boxes="001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }
}

class Solution2 {
    public int[] minOperations(String boxes) {
        int left = boxes.charAt(0) - '0', right = 0, operations = 0;
        int n = boxes.length();
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                operations += i;
            }
        }
        int[] res = new int[n];
        res[0] = operations;
        for (int i = 1; i < n; i++) {
            operations += left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            res[i] = operations;
        }
        return res;
    }
}