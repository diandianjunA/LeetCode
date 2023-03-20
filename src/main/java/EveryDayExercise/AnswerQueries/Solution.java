package EveryDayExercise.AnswerQueries;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sum = new int[nums.length];
        int[] answer = new int[queries.length];
        sum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i]=sum[i-1]+nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < sum.length; j++) {
                if(sum[j]>queries[i]){
                    break;
                }
                answer[i]=j+1;
            }
        }
        return answer;
    }

    @Test
    public void test1(){
        int[] nums={4,5,2,1};
        int[] queries={3,10,21};
        System.out.println(Arrays.toString(answerQueries(nums,queries)));
    }

    @Test
    public void test2(){
        int[] nums={2,3,4,5};
        int[] queries={0};
        System.out.println(Arrays.toString(answerQueries(nums,queries)));
    }
}
