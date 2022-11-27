package EveryDayExercise.BuildArray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        int j=0;
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(target[j]==i){
                res.add("Push");
                j++;
            }else{
                res.add("Push");
                res.add("Pop");
            }
            if(j==target.length){
                break;
            }
        }
        return res;
    }
    @Test
    public void test1(){
        int[] target={1,3};
        int n=3;
        for (String s : buildArray(target, n)) {
            System.out.println(s);
        }
    }
    @Test
    public void test2(){
        int[] target={1,2,3};
        int n=3;
        for (String s : buildArray(target, n)) {
            System.out.println(s);
        }
    }
    @Test
    public void test3(){
        int[] target={1,2};
        int n=4;
        for (String s : buildArray(target, n)) {
            System.out.println(s);
        }
    }
}
