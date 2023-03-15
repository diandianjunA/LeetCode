package PracticePackage.Subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            int key;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                key=1<<j;
                if((key&i)!=0){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={1,2,3};
        for (List<Integer> subset : subsets(nums)) {
            System.out.println(subset);
        }
    }
}
