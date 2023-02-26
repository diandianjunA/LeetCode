package EveryDayExercise.MinMovesToExchange;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minMoves(int[] nums, int k) {
        ArrayList<Integer> loc = new ArrayList<>();
        ArrayList<Long> sum = new ArrayList<>();
        int i = 0;
        while(nums[i]!=1){
            i++;
        }
        loc.add(i);
        sum.add((long) i);
        int length=1;
        int maxLength=1;
        for (i = i+1; i < nums.length; i++) {
            if(nums[i]==1){
                length++;
                loc.add(i);
                sum.add(sum.get(sum.size()-1)+i);
            }else{
                if(length>maxLength){
                    maxLength=length;
                }
                length=0;
            }
        }
        if(length>maxLength){
            maxLength=length;
        }
        if(maxLength>=k){
            return 0;
        }
        long num=Integer.MAX_VALUE;
        for (int j = 0; j+k-1 < loc.size(); j++) {
            long res;
            if(k%2==0){
                res=(long)(k/2)*loc.get(j+k/2)-(sum.get(j+k/2-1)-sum.get(j)+loc.get(j))-(long)(k/2)*(k/2+1)/2+sum.get(j+k-1)-sum.get(j+k/2)-(long) (k / 2 - 1) *loc.get(j+k/2)-(long)(k/2)*(k/2-1)/2;
            }else{
                res=(long)(k/2)*loc.get(j+k/2)-(sum.get(j+k/2-1)-sum.get(j)+loc.get(j))-(long)(k/2)*(k/2+1)/2+sum.get(j+k-1)-sum.get(j+k/2)-(long) (k / 2) *loc.get(j+k/2)-(long)(k/2)*(k/2+1)/2;
            }
            num=Math.min(num,res);
        }
        return (int) num;
    }

    @Test
    public void test1(){
        int[] nums={1,0,0,1,0,1};
        int k=2;
        System.out.println(minMoves(nums,k));
    }

    @Test
    public void test2(){
        int[] nums={1,0,0,0,0,0,1,1};
        int k=3;
        System.out.println(minMoves(nums,k));
    }

    @Test
    public void test3(){
        int[] nums={1,1,0,1};
        int k=2;
        System.out.println(minMoves(nums,k));
    }

    @Test
    public void test4(){
        int[] nums={1,0,0,1,0,1,1,1,0,1,1};
        int k=7;
        System.out.println(minMoves(nums,k));
    }

    @Test
    public void test5(){
        int[] nums={0,0,0,0,0,1,0,0,0,1,0,1,0,0,0};
        int k=3;
        System.out.println(minMoves(nums,k));
    }

    @Test
    public void test6(){
        int[] nums={0,1,0,0,1,1,0,1,0,1,1,1,1,0,1,0};
        int k=7;
        System.out.println(minMoves(nums,k));
    }

    @Test
    public void test7(){
        int[] nums={0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k=15;
        System.out.println(minMoves(nums,k));
    }
}
