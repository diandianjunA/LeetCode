package DoubleWeekCompetition100.RepairCars;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long time= (long) ranks[0] *cars*cars;
        int[] r = new int[ranks.length];
        r[0]=cars;
        while(true){
            for (int i = 1; i < ranks.length; i++) {
                long time1=(long) ranks[0] *(r[0]-1)*(r[0]-1);
                long time2=(long) ranks[i] *(r[i]+1)*(r[i]+1);
                if(time1>time2){
                    time=time1;
                    r[0]--;
                    r[i]++;
                }else{
                    return Math.min(time2,time);
                }
            }
        }
    }

    @Test
    public void test1(){
        int[] rank={4,2,3,1};
        int car=10;
        System.out.println(repairCars(rank,car));
    }

    @Test
    public void test2(){
        int[] rank={5,1,8};
        int car=6;
        System.out.println(repairCars(rank,car));
    }

    @Test
    public void test3(){
        int[] rank={1,1,3,3};
        int car=74;
        System.out.println(repairCars(rank,car));
    }
}

class Solution2 {
    public long repairCars(int[] ranks, int cars) {
        int min_r = ranks[0];
        for (int r : ranks) min_r = Math.min(min_r, r);
        long left = 0, right = (long) min_r * cars * cars;
        while (left + 1 < right) { // 开区间
            long mid = (left + right) / 2, s = 0;
            for (int r : ranks)
                s += Math.sqrt(mid / r);
            if (s >= cars) right = mid;
            else left = mid;
        }
        return right;
    }
}