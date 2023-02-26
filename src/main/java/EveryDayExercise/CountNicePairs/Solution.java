package EveryDayExercise.CountNicePairs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countNicePairs(int[] nums) {
        int mod=1000000007;
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]-rev(nums[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        long res=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            res=(res+ (long) entry.getValue() *(entry.getValue()-1)/2)%mod;
        }
        return (int) res;
    }

    public int rev(int n){
        int res=0;
        while(n>0){
            res=res*10+n%10;
            n=n/10;
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={42,11,1,97};
        System.out.println(countNicePairs(nums));
    }
}
