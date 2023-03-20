package WeekCompetition336.MaxScore;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long prefix=0;
        int res=0;
        for (int i = nums.length-1; i >= 0; i--) {
            prefix+=nums[i];
            if(prefix>0){
                res++;
            }else{
                return res;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={2,-1,0,1,-3,3,-3};
        System.out.println(maxScore(nums));
    }

    @Test
    public void test2(){
        int[] nums={-2,-3,0};
        System.out.println(maxScore(nums));
    }
}
