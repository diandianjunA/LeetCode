package EveryDayExercise.MaxValue;

import org.junit.Test;

public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left=1;
        int right=maxSum;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(valid(n,index,maxSum,mid)){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    public boolean valid(int n,int index,int maxSum,int num){
        long left=0;
        long right=0;
        if(index+1>num){
            left= (long) (1 + num - 1) *(num-1)/2+(index+1-num);
        }else{
            left= (long) (num - index + num - 1) *index/2;
        }
        if(n-index>num){
            right= (long) (1 + num - 1) *(num-1)/2+(n-index-num);
        }else{
            right= (long) (num - (n - index - 1) + num - 1) *(n-index-1)/2;
        }
        return (left+right+num)<=maxSum;
    }

    @Test
    public void test1(){
        int n=4;
        int index=2;
        int maxSum=6;
        System.out.println(maxValue(n,index,maxSum));
    }

    @Test
    public void test2(){
        int n=6;
        int index=1;
        int maxSum=10;
        System.out.println(maxValue(n,index,maxSum));
    }

    @Test
    public void test3(){
        int n=6;
        int index=2;
        int maxSum=931384943;
        System.out.println(maxValue(n,index,maxSum));
    }
}
