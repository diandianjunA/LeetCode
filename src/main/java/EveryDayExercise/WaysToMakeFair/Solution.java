package EveryDayExercise.WaysToMakeFair;

import org.junit.Test;

public class Solution {
    public int waysToMakeFair(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int[] temp = new int[nums.length];
        temp[temp.length-1]=nums[nums.length-1];
        temp[temp.length-2]=nums[nums.length-2];
        for (int i=temp.length-3;i>=0;i--){
            temp[i]=temp[i+2]+nums[i];
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            int sum1=0;
            int sum2=0;
            if(i%2==0){
                if(i<nums.length-2){
                    sum1=temp[0]-temp[i]+temp[i+1];
                    sum2=temp[1]-temp[i+1]+temp[i+2];
                }else{
                    if(i==nums.length-2){
                        sum1=temp[0]-nums[i]+nums[i+1];
                        sum2=temp[1]-nums[i+1];
                    }else {
                        sum1=temp[0]-nums[i];
                        sum2=temp[1];
                    }
                }
            }else {
                if(i<nums.length-2){
                    sum2=temp[1]-temp[i]+temp[i+1];
                    sum1=temp[0]-temp[i+1]+temp[i+2];
                }else{
                    if(i==nums.length-2){
                        sum2=temp[1]-nums[i]+nums[i+1];
                        sum1=temp[0]-nums[i+1];
                    }else {
                        sum2=temp[1]-nums[i];
                        sum1=temp[0];
                    }
                }
            }
            if(sum1==sum2){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={2,1,6,4};
        System.out.println(waysToMakeFair(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,1,1};
        System.out.println(waysToMakeFair(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3};
        System.out.println(waysToMakeFair(nums));
    }
}
