package WeekCompetition336.BeautifulSubarrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long beautifulSubarrays(int[] nums) {
        int[] temp = new int[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        long res=0;
        map.put(0,1);
        for (int i = 1; i < temp.length; i++) {
            temp[i]=temp[i-1]^nums[i-1];
            map.put(temp[i],map.getOrDefault(temp[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            res+=((long) entry.getValue() *(entry.getValue()-1))/2;
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={4,3,1,2,4};
        System.out.println(beautifulSubarrays(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,10,4};
        System.out.println(beautifulSubarrays(nums));
    }

    @Test
    public void test3(){
        int[] nums={0,0,0};
        System.out.println(beautifulSubarrays(nums));
    }

}
