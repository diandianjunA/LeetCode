package EveryDayExercise.MovesToMakeZigzag;

import org.junit.Test;

public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int res1=0;
        int res2=0;
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i]=nums[i];
            nums2[i]=nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            if(i%2==0){
                if(nums1[i]>=nums1[i-1]){
                    res1+=nums1[i]-nums1[i-1]+1;
                    nums1[i]=nums1[i-1]-1;
                }
            }else{
                if(nums1[i]<=nums1[i-1]){
                    res1+=nums1[i-1]-nums1[i]+1;
                    nums1[i-1]=nums1[i]-1;
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if(i%2==1){
                if(nums2[i]>=nums2[i-1]){
                    res2+=nums2[i]-nums2[i-1]+1;
                    nums2[i]=nums2[i-1]-1;
                }
            }else{
                if(nums2[i]<=nums2[i-1]){
                    res2+=nums2[i-1]-nums2[i]+1;
                    nums2[i-1]=nums2[i]-1;
                }
            }
        }
        return Math.min(res1,res2);
    }

    @Test
    public void test1(){
        int[] nums={1,2,3};
        System.out.println(movesToMakeZigzag(nums));
    }

    @Test
    public void test2(){
        int[] nums={9,6,1,6,2};
        System.out.println(movesToMakeZigzag(nums));
    }

}
