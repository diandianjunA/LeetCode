package EveryDayExercise.NumSubarrayBoundedMax;

import org.junit.Test;

public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[] info = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<left){
                info[i]=0;
            } else if (nums[i] > right) {
                info[i]=2;
            }else{
                info[i]=1;
            }
        }
        int last1=-1;
        int last2=-1;
        int res=0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 1) {
                last1=i;
            } else if (info[i] == 2) {
                last2=i;
                last1=-1;
            }
            if (last1!=-1){
                res+=last1-last2;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={2,1,4,3};
        int left=2;
        int right=3;
        System.out.println(numSubarrayBoundedMax(nums,left,right));
    }

    @Test
    public void test2(){
        int[] nums={2,9,2,5,6};
        int left=2;
        int right=8;
        System.out.println(numSubarrayBoundedMax(nums,left,right));
    }

}
