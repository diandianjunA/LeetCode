package DataStructureLearningPlan;

import org.junit.Test;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    res=new int[]{i,j};
                    return res;
                }
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target){
        int[] res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                res=new int[]{map.get(target-nums[i]),i};
                return res;
            }
            map.put(nums[i],i);
        }
        return null;
    }
    @Test
    public void test(){
        int[] nums={3,3};
        int target=6;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
