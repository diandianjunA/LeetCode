package EveryDayExercise.ClosestCost;

import org.junit.Test;

public class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            if(baseCosts[i]<min){
                min=baseCosts[i];
            }
        }
        if(min>target){
            return min;
        }
        int upper=2*target-min;
        for (int i = 0; i < baseCosts.length; i++) {
            if(baseCosts[i]>target){
                if(baseCosts[i]<upper){
                    upper=baseCosts[i];
                }
            }
        }
        int bigger=upper;
        boolean[] dp = new boolean[target+1];
        for (int i = 0; i < baseCosts.length; i++) {
            if(baseCosts[i]>target){
                continue;
            }
            dp[baseCosts[i]]=true;
        }
        for (int i = 0; i < toppingCosts.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = target; k >= min; k--) {
                    if(dp[k]&&k+toppingCosts[i]>target){
                        bigger=Math.min(bigger,k+toppingCosts[i]);
                    }else if(k>toppingCosts[i]){
                        dp[k]=dp[k]|dp[k-toppingCosts[i]];
                    }
                }
            }
        }
        for (int i = target; true; i--) {
            if(dp[i]){
                if(target-i<=bigger-target){
                    return i;
                }else{
                    return bigger;
                }
            }
        }
    }

    @Test
    public void test1(){
        int[] baseCosts={1,7};
        int[] toppingCosts={3,4};
        int target=10;
        System.out.println(closestCost(baseCosts,toppingCosts,target));
    }

    @Test
    public void test2(){
        int[] baseCosts={2,3};
        int[] toppingCosts={4,5,100};
        int target=18;
        System.out.println(closestCost(baseCosts,toppingCosts,target));
    }

    @Test
    public void test3(){
        int[] baseCosts={3,10};
        int[] toppingCosts={2,5};
        int target=9;
        System.out.println(closestCost(baseCosts,toppingCosts,target));
    }

    @Test
    public void test4(){
        int[] baseCosts={10};
        int[] toppingCosts={1};
        int target=1;
        System.out.println(closestCost(baseCosts,toppingCosts,target));
    }
}
