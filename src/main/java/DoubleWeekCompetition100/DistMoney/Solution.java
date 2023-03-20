package DoubleWeekCompetition100.DistMoney;

import org.junit.Test;

public class Solution {
    public int distMoney(int money, int children) {
        money-=children;
        if(money<0){
            return -1;
        }
        int res=0;
        for (int i = 0; i < children; i++) {
            if(money>=7){
                money-=7;
                res++;
            }else{
                if(money==3){
                    if(i==children-1){
                        return res-1;
                    }else{
                        return res;
                    }
                }else{
                    return res;
                }
            }
        }
        if(money==0){
            return res;
        }else{
            return res-1;
        }
    }

    @Test
    public void test1(){
        int money=20;
        int children=3;
        System.out.println(distMoney(money,children));
    }

    @Test
    public void test2(){
        int money=16;
        int children=2;
        System.out.println(distMoney(money,children));
    }
}
