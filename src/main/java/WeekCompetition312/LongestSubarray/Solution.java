package WeekCompetition312.LongestSubarray;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int max=0;
        boolean index=false;
        int maxLength=0;
        int length=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max=nums[i];
                list.clear();
                list.add(nums[i]);
                index=true;
                maxLength=1;
                length=1;
            }else if(nums[i]==max&&index){
                list.add(nums[i]);
            }else if(nums[i]==max&&!index){
                length++;
            }else{
                if(length>maxLength&&length>list.size()){
                    maxLength=length;
                } else if (list.size() > maxLength && list.size() > length) {
                    maxLength=list.size();
                }
                index=false;
                length=0;
            }

        }
        if(length>maxLength&&length>list.size()){
            maxLength=length;
        } else if (list.size() > maxLength && list.size() > length) {
            maxLength=list.size();
        }
        return maxLength;
    }
    @Test
    public void test(){
        int[] nums={117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,117793,109282,109282,109282,109282,109282,109282,109282,109282,109282,109282,109282,109282,109282,169349};
        System.out.println(longestSubarray(nums));
    }
}
