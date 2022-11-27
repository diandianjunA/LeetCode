package EveryDayExercise.ShortestSubarray;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        long[] pre=new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            pre[i+1]=pre[i]+nums[i];
        }
        int res=nums.length+1;
        for (int i = 0; i < nums.length; i++) {
            long sum=pre[i];
            while(!deque.isEmpty()&&(sum-pre[deque.peekFirst()]>=k)){
                res=Math.min(res,i-deque.pollFirst());
            }
            while (!deque.isEmpty()&&(pre[deque.peekLast()]>sum)){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res==nums.length+1?-1:res;
    }
    @Test
    public void test1(){
        int[] nums={1};
        int k=1;
        System.out.println(shortestSubarray(nums,k));
    }
    @Test
    public void test2(){
        int[] nums={1,2};
        int k=4;
        System.out.println(shortestSubarray(nums,k));
    }
    @Test
    public void test3(){
        int[] nums={2,-1,2};
        int k=3;
        System.out.println(shortestSubarray(nums,k));
    }
    @Test
    public void test4(){
        int[] nums={17,85,93,-45,-21};
        int k=150;
        System.out.println(shortestSubarray(nums,k));
    }
}
