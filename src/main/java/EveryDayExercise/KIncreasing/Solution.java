package EveryDayExercise.KIncreasing;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int kIncreasing(int[] arr, int k) {
        int res=0;
        for (int i = 0; i < k; i++) {
            res=res+adjust(arr,i,k);
        }
        return res;
    }

    public int adjust(int[] arr,int from,int k){
        int[] dp = new int[arr.length];
        for (int i = from; i < arr.length; i=i+k) {
            dp[i]=1;
            for (int j = i-k; j >= 0 ; j=j-k) {
                if(arr[j]<=arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        int length=0;
        for (int i = from; i < arr.length; i=i+k) {
            length++;
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return length-max;
    }

    Solution2 solution2 = new Solution2();

    @Test
    public void test(){
        int[] arr={5,4,3,2,1};
        int k=1;
        System.out.println(solution2.kIncreasing(arr,k));
    }

    @Test
    public void test1(){
        int[] arr={4,1,5,2,6,2};
        int k=2;
        System.out.println(solution2.kIncreasing(arr,k));
    }

    @Test
    public void test2(){
        int[] arr={4,1,5,2,6,2};
        int k=3;
        System.out.println(solution2.kIncreasing(arr,k));
    }

    @Test
    public void test3(){
        int[] arr={3,9,4,1,3,1,3,9,5};
        int k=1;
        System.out.println(solution2.kIncreasing(arr,k));
    }

    @Test
    public void test4(){
        int[] arr={2,2,2,2,2,1,1,4,4,3,3,3,3,3};
        int k=1;
        System.out.println(solution2.kIncreasing(arr,k));
    }

    @Test
    public void test5(){
        int[] arr={12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3};
        int k=11;
        System.out.println(solution2.kIncreasing(arr,k));
    }
}

class Solution2 {
    public int kIncreasing(int[] arr, int k) {
        int res=0;
        ArrayList<Integer> low = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res=res+adjust(arr,i,k,low);
            low.clear();
        }
        return res;
    }

    public int adjust(int[] arr,int from,int k,ArrayList<Integer> low){
        low.add(arr[from]);
        int j=1;
        for (int i = from+k; i < arr.length; i=i+k) {
            j++;
            int left=0;
            int right=low.size()-1;
            int pos=-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(low.get(mid)<=arr[i]){
                    pos=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            if(pos+1>=low.size()){
                low.add(arr[i]);
            }else{
                low.set(pos+1,arr[i]);
            }
        }
        return j-low.size();
    }
}