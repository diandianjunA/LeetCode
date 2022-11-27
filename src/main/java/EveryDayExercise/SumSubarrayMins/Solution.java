package EveryDayExercise.SumSubarrayMins;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        long res=0;
        for (int i = 0; i < arr.length; i++) {
            if(deque.isEmpty()){
                deque.offerLast(i);
            }else{
                while (!deque.isEmpty()&&arr[deque.peekLast()]>arr[i]){
                    Integer pop = deque.pollLast();
                    if(!deque.isEmpty()){
                        res=(res+ (long) arr[pop] *(i-pop)*(pop-deque.peekLast()))%1000000007;
                    }else {
                        res=(res+ (long) arr[pop] *(i-pop)*(pop +1))%1000000007;
                    }
                }
                deque.offerLast(i);
            }
        }
        int pre=0;
        while(!deque.isEmpty()){
            Integer pop = deque.pollFirst();
            res=(res+ (long) arr[pop] *(arr.length-pop)*(pop-pre+1))%1000000007;
            pre=pop+1;
        }
        return (int) res;
    }
    @Test
    public void test1(){
        int[] arr={3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
    @Test
    public void test2(){
        int[] arr={11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr));
    }
    @Test
    public void test3(){
        int[] arr={85,93,93,90};
        System.out.println(sumSubarrayMins(arr));
    }
    @Test
    public void test4(){
        int[] arr={23,80,34,82,11};
        System.out.println(sumSubarrayMins(arr));
    }
}
class Solution2 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }
}