package EveryDayExercise.MinOperationsMaxProfit;

import org.junit.Test;

public class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit=0;
        int minPos=0;
        int i=0;
        int profit=0;
        int pos=0;
        while (customers[i]==0){
            i++;
            pos++;
        }
        int waiting=customers[i];
        i++;
        while(waiting>0||i<customers.length){
            int up=Math.min(waiting,4);
            waiting-=up;
            profit+=boardingCost *up-runningCost;
            pos++;
            if(profit>maxProfit){
                maxProfit=profit;
                minPos=pos;
            }
            if(i<customers.length){
                waiting+=customers[i];
                i++;
            }
        }
        if(maxProfit<=0){
            return -1;
        }else{
            return minPos;
        }
    }

    @Test
    public void test1(){
        int[] customer={8,3};
        int boardCost=5;
        int runningCost=6;
        System.out.println(minOperationsMaxProfit(customer,boardCost,runningCost));
    }

    @Test
    public void test2(){
        int[] customer={10,9,6};
        int boardCost=6;
        int runningCost=4;
        System.out.println(minOperationsMaxProfit(customer,boardCost,runningCost));
    }

    @Test
    public void test3(){
        int[] customer={3,4,0,5,1};
        int boardCost=1;
        int runningCost=92;
        System.out.println(minOperationsMaxProfit(customer,boardCost,runningCost));
    }

    @Test
    public void test4(){
        int[] customer={0,43,37,9,23,35,18,7,45,3,8,24,1,6,37,2,38,15,1,14,39,27,4,25,27,33,43,8,44,30,38,40,20,5,17,27,43,11,6,2,30,49,30,25,32,3,18,23,45,43,30,14,41,17,42,42,44,38,18,26,32,48,37,5,37,21,2,9,48,48,40,45,25,30,49,41,4,48,40,29,23,17,7,5,44,23,43,9,35,26,44,3,26,16,31,11,9,4,28,49,43,39,9,39,37,7,6,7,16,1,30,2,4,43,23,16,39,5,30,23,39,29,31,26,35,15,5,11,45,44,45,43,4,24,40,7,36,10,10,18,6,20,13,11,20,3,32,49,34,41,13,11,3,13,0,13,44,48,43,23,12,23,2};
        int boardCost=43;
        int runningCost=54;
        System.out.println(minOperationsMaxProfit(customer,boardCost,runningCost));
    }

    @Test
    public void test5(){
        int[] customer={1,0,3};
        int boardCost=61;
        int runningCost=55;
        System.out.println(minOperationsMaxProfit(customer,boardCost,runningCost));
    }
}
