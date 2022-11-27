package DataStructureLearningPlan;

import org.junit.Test;

import java.util.HashSet;

public class ContainsDuplicate {
    //我的解法
    //执行用时：6 ms, 在所有 Java 提交中击败了76.15%的用户
    //内存消耗：49.1 MB, 在所有 Java 提交中击败了98.51%的用户
    //通过测试用例：70 / 70
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        boolean result=true;
        for (int i = 0; i < nums.length; i++) {
            if(result){
                result=integers.add(nums[i]);
            }else{
                return true;
            }
        }
        return !result;
    }
    @Test
    public void test(){
        int[] nums= new int[]{0,4,5,0,3,6};
        System.out.println(containsDuplicate(nums));
    }
}
