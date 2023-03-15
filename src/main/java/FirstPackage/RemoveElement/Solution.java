package FirstPackage.RemoveElement;

import org.junit.Test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    @Test
    public void test1(){
        int[] nums={3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));
    }

    @Test
    public void test2(){
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println(removeElement(nums,val));
    }
}
