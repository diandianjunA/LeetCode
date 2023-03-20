package FirstPackage.SearchInsert;

import org.junit.Test;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    @Test
    public void test1(){
        int[] nums={1,3,5,6};
        int target=5;
        System.out.println(searchInsert(nums,target));
    }

    @Test
    public void test2(){
        int[] nums={1,3,5,6};
        int target=2;
        System.out.println(searchInsert(nums,target));
    }

    @Test
    public void test3(){
        int[] nums={1,3,5,6};
        int target=7;
        System.out.println(searchInsert(nums,target));
    }
}
