package EveryDayExercise.TotalFruit;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length<=2){
            return fruits.length;
        }
        int l=0,r=0;
        while(r+1<fruits.length&&fruits[r]==fruits[l]){
            r++;
        }
        int temp1=r;
        while(r+1<fruits.length&&(fruits[r+1]==fruits[r]||fruits[r+1]==fruits[l]||fruits[r+1]==fruits[temp1])){
            r++;
        }
        int temp2=r;
        while(temp2>temp1&&fruits[temp2-1]==fruits[r]){
            temp2--;
        }
        int maxlength=r-l+1;
        while (r<fruits.length){
            l=temp2;
            r++;
            temp1=r;
            while(r+1<fruits.length&&(fruits[r+1]==fruits[r]||fruits[r+1]==fruits[temp1]||fruits[r+1]==fruits[l])){
                r++;
            }
            temp2=r;
            while(temp2>temp1&&fruits[temp2-1]==fruits[r]){
                temp2--;
            }
            if(r-l+1>maxlength){
                maxlength=r-l+1;
            }
        }
        return maxlength;
    }
    @Test
    public void test(){
        int[] fruit={1,2,1};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test2(){
        int[] fruit={0,1,2,2};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test3(){
        int[] fruit={1,2,3,2,2};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test4(){
        int[] fruit={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test5(){
        int[] fruit={1,0,3,4,3};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test6(){
        int[] fruit={3,3,3,3,3,3};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test7(){
        int[] fruit={5,2,5,2,0,3};
        System.out.println(totalFruit(fruit));
    }
    @Test
    public void test8(){
        int[] fruit={0,1,6,6,4,4,6};
        System.out.println(totalFruit(fruit));
    }
}
class Solution2 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}