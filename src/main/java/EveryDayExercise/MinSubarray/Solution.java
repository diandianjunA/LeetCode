package EveryDayExercise.MinSubarray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        ArrayList<Integer> list = new ArrayList<>();
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            preSum[i+1]=preSum[i]+nums[i];
            list.add(nums[i]);
        }
        int mod= (int) (sum%p);
        if(mod==0){
            return 0;
        }
        if(list.contains(mod)){
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int y=0;
        int res=nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(y,i);
            y=(y+nums[i])%p;
            if(map.containsKey((y-mod+p)%p)){
                res=Math.min(res,i-map.get((y-mod+p)%p)+1);
            }
        }
        return res==nums.length?-1:res;
    }

    @Test
    public void test1(){
        int[] nums={3,1,4,2};
        int p=6;
        System.out.println(minSubarray(nums,p));
    }

    @Test
    public void test2(){
        int[] nums={6,3,5,2};
        int p=9;
        System.out.println(minSubarray(nums,p));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3};
        int p=3;
        System.out.println(minSubarray(nums,p));
    }

    @Test
    public void test4(){
        int[] nums={1,2,3};
        int p=7;
        System.out.println(minSubarray(nums,p));
    }

    @Test
    public void test5(){
        int[] nums={1000000000,1000000000,1000000000};
        int p=3;
        System.out.println(minSubarray(nums,p));
    }

    @Test
    public void test6(){
        int[] nums={4,4,2};
        int p=7;
        System.out.println(minSubarray(nums,p));
    }

    @Test
    public void test7(){
        int[] nums={26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        int p=26;
        System.out.println(minSubarray(nums,p));
    }
}
