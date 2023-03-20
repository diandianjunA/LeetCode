package FirstPackage.Search;

import org.junit.Test;

public class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if(target>nums[0]){
            while(left<=right){
                int t=left+(right-left)/2;
                if(nums[t]>=nums[left]){
                    if(nums[t]>target){
                        return binarySearch(nums,left,t,target);
                    }else if(nums[t]==target){
                        return t;
                    }else{
                        left=t+1;
                    }
                }else{
                    right=t-1;
                }
            }
        } else if (target == nums[0]) {
            return 0;
        } else{
            while(left<=right){
                int t=left+(right-left)/2;
                if(nums[t]<=nums[right]){
                    if(nums[t]<target){
                        return binarySearch(nums,t,right,target);
                    }else if(nums[t]==target){
                        return t;
                    }else{
                        right=t-1;
                    }
                }else{
                    left=t+1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums,int left,int right,int target){
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
        return -1;
    }

    @Test
    public void test1(){
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }

    @Test
    public void test2(){
        int[] nums={0,1,2,3,4,5,6,7};
        System.out.println(binarySearch(nums,0,7,6));
    }

    @Test
    public void test3(){
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
    }

    @Test
    public void test4(){
        int[] nums={1};
        System.out.println(search(nums,0));
    }

    @Test
    public void test5(){
        int[] nums={1};
        System.out.println(search(nums,1));
    }

    @Test
    public void test6(){
        int[] nums={1,3};
        System.out.println(search(nums,3));
    }

    @Test
    public void test7(){
        int[] nums={1};
        System.out.println(search(nums,2));
    }
}
