package FirstPackage.FourSum;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if((long)nums[i]+nums[j]+nums[k]+nums[l]==target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        if(!res.contains(list)){
                            res.add(list);
                        }
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(nums,target));
    }

    @Test
    public void test2(){
        int[] nums={2,2,2,2,2};
        int target=8;
        System.out.println(fourSum(nums,target));
    }
}
