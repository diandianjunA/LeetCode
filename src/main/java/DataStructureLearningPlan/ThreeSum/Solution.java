package DataStructureLearningPlan.ThreeSum;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if(i!=j&&i!=k&&j!=k){
                        if(nums[i]+nums[j]+nums[k]==0){
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            Collections.sort(list);
                            if(check(res,list)){
                                res.add(list);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    public boolean check(List<List<Integer>> res,List<Integer> temp){
        for (List<Integer> list:res){
            if(list.equals(temp)){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[] nums={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        for (List<Integer> list : threeSum(nums)) {
            System.out.println(list);
        }
    }
}
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}