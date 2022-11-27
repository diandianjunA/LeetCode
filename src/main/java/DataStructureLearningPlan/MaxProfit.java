package DataStructureLearningPlan;

import org.junit.Test;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            if(prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    @Test
    public void test(){
        int[] price=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(price));
    }
}
