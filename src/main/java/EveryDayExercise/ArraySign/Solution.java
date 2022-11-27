package EveryDayExercise.ArraySign;

public class Solution {
    public int arraySign(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                res++;
            } else if (nums[i] == 0) {
                return 0;
            }
        }
        return (res%2==0)?1:-1;
    }
}
