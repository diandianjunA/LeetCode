package FirstPackage.NextPermutation;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] nextPermutation(int[] nums) {
        deal(nums,0);
        return nums;
    }

    public boolean check(int[] nums,int from){
        for (int i = nums.length-1; i > from; i--) {
            if(nums[i]>nums[i-1]){
                return false;
            }
        }
        return true;
    }

    public void deal(int[] nums,int i){
        boolean check = check(nums, i+1);
        if(check){
            int j=nums.length-1;
            for (;j>i;j--){
                if(nums[j]>nums[i]){
                    break;
                }
            }
            if(j==i){
                Arrays.sort(nums);
            }else{
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                Arrays.sort(nums,i+1,nums.length);
            }
        }else{
            deal(nums,i+1);
        }
    }

    @Test
    public void test1(){
        int[] nums={1,2,3};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    @Test
    public void test2(){
        int[] nums={1,3,2};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    @Test
    public void test3(){
        int[] nums={2, 3, 1};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    @Test
    public void test4(){
        int[] nums={3, 1, 2};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    @Test
    public void test5(){
        int[] nums={3, 2, 1};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    @Test
    public void test6(){
        int[] nums={1, 1, 5};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }
}
