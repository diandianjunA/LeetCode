package DoubleWeekCompetition100.FindScore;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public long findScore(int[] nums) {
        Integer[] sort = new Integer[nums.length];
        for (int i = 0; i < sort.length; i++) {
            sort[i]=i;
        }
        Arrays.sort(sort, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1]-nums[o2];
            }
        });
        boolean[] visited = new boolean[nums.length];
        long score=0;
        for (int i = 0; i < sort.length; i++) {
            if(!visited[sort[i]]){
                score+=nums[sort[i]];
                visited[sort[i]]=true;
                if(sort[i]>0){
                    visited[sort[i]-1]=true;
                }
                if(sort[i]<nums.length-1){
                    visited[sort[i]+1]=true;
                }
            }
        }
        return score;
    }

    @Test
    public void test1(){
        int[] nums={2,1,3,4,5,2};
        System.out.println(findScore(nums));
    }

    @Test
    public void test2(){
        int[] nums={2,3,5,1,3,2};
        System.out.println(findScore(nums));
    }

}
