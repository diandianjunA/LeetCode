package WeekCompetition337.BeautifulSubsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int res=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(Math.abs(nums[i]-nums[j])==k){
                    int key=(1<<i)|(1<<j);
                    if(!list.contains(key)){
                        list.add(key);
                    }
                }
            }
        }
        for (int i = 1; i < (1 << nums.length); i++) {
            boolean has=false;
            for (Integer key:list){
                if((key&i)==key){
                    has=true;
                    break;
                }
            }
            if(!has){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums={2,4,6};
        int k=2;
        System.out.println(beautifulSubsets(nums,k));
    }

    @Test
    public void test2(){
        int[] nums={1};
        int k=1;
        System.out.println(beautifulSubsets(nums,k));
    }
}
