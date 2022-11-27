package EveryDayExercise.JobScheduling;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] data = new int[startTime.length][3];
        for (int i = 0; i < data.length; i++) {
            data[i][0]=startTime[i];
            data[i][1]=endTime[i];
            data[i][2]=profit[i];
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[] dp = new int[data.length+1];
        int[] assist = new int[dp.length];
        dp[0]=0;
        assist[0]=0;
        int index=0;
        for (int i = 1; i < dp.length; i++) {
            index = minFind(data, i-1,data[i-1][0]);
            dp[i]=Math.max(dp[i-1],dp[index]+data[i-1][2]);
        }
        return dp[dp.length-1];
    }
    public int minFind(int[][] data,int right,int target){
        int left=0;
        int middle;
        while(left<right){
            middle=left+(right-left)/2;
            if(data[middle][1]>target){
                right=middle;
            }else{
                left=middle+1;
            }
        }
        return left;
    }
    @Test
    public void test1(){
        int[] startTime={1,2,3,3};
        int[] endTime={3,4,5,6};
        int[] profit={50,10,40,70};
        System.out.println(jobScheduling(startTime,endTime,profit));
    }
    @Test
    public void test2(){
        int[] startTime={1,2,3,4,6};
        int[] endTime={3,5,10,6,9};
        int[] profit={20,20,100,70,60};
        System.out.println(jobScheduling(startTime,endTime,profit));
    }
    @Test
    public void test3(){
        int[] startTime={1,1,1};
        int[] endTime={2,3,4};
        int[] profit={5,6,4};
        System.out.println(jobScheduling(startTime,endTime,profit));
    }
    @Test
    public void test4(){
        int[] startTime={1,2,2,3};
        int[] endTime={2,5,3,4};
        int[] profit={3,4,1,2};
        System.out.println(jobScheduling(startTime,endTime,profit));
    }
    @Test
    public void test5(){
        int[] startTime={6,15,7,11,1,3,16,2};
        int[] endTime={19,18,19,16,10,8,19,8};
        int[] profit={2,9,1,19,5,7,3,19};
        System.out.println(jobScheduling(startTime,endTime,profit));
    }
}
