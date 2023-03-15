package FirstPackage.RemoveDuplicates;

import org.junit.Test;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    @Test
    public void test1(){
        int[] nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    @Test
    public void test2(){
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
