package EveryDayExercise.MinusMinOperations;

import org.junit.Test;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int target=sum-x;
        if(target==0){
            return nums.length;
        }
        int length=1;
        int maxLength=-1;
        int left=0;
        int right=0;
        int tempSum=nums[left];
        if(tempSum==target){
            maxLength=1;
        }
        while(left<=right&&right<nums.length-1){
            if (tempSum + nums[right+1] > target) {
                while (left<=right+1&&tempSum + nums[right+1] > target) {
                    tempSum -= nums[left];
                    length--;
                    left++;
                }
            }
            right++;
            length++;
            tempSum+=nums[right];
            if(tempSum==target&&length>maxLength){
                maxLength=length;
            }
        }
        if(tempSum>target||maxLength==-1||nums.length==maxLength){
            return -1;
        } else {
            return nums.length-maxLength;
        }
    }
    @Test
    public void test1(){
        int[] nums={1,1,4,2,3};
        int x=5;
        System.out.println(minOperations(nums,x));
    }

    @Test
    public void test2(){
        int[] nums={5,6,7,8,9};
        int x=4;
        System.out.println(minOperations(nums,x));
    }

    @Test
    public void test3(){
        int[] nums={3,2,20,1,1,3};
        int x=10;
        System.out.println(minOperations(nums,x));
    }

    @Test
    public void test4(){
        int[] nums={10,1,1,1,1,1};
        int x=5;
        System.out.println(minOperations(nums,x));
    }
}
