package FirstPackage.SearchRange;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                int i=0;
                while(mid-i>=0&&nums[mid-i]==target){
                    i++;
                }
                int j=0;
                while(mid+j<nums.length&&nums[mid+j]==target){
                    j++;
                }
                return new int[]{mid-i+1,mid+j-1};
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    @Test
    public void test1(){
        int[] nums={5,7,7,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    @Test
    public void test2(){
        int[] nums={5,7,7,8,8,10};
        int target=6;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    @Test
    public void test3(){
        int[] nums={};
        int target=0;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    @Test
    public void test4(){
        int[] nums={1};
        int target=1;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
}
