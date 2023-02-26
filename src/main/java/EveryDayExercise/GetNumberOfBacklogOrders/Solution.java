package EveryDayExercise.GetNumberOfBacklogOrders;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for (int[] order : orders) {
            if (order[2] == 0) {
                while(true){
                    int[] peek = sell.peek();
                    if (peek != null && peek[0] <= order[0]) {
                        if(peek[1]<order[1]){
                            sell.poll();
                            order[1]-=peek[1];
                        }else if(peek[1]>order[1]){
                            peek[1]-=order[1];
                            break;
                        }else{
                            sell.poll();
                            break;
                        }
                    } else {
                        buy.add(order);
                        break;
                    }
                }
            } else {
                while(true){
                    int[] peek = buy.peek();
                    if (peek != null && peek[0] >= order[0]) {
                        if(peek[1]<order[1]){
                            buy.poll();
                            order[1]-=peek[1];
                        }else if(peek[1]>order[1]){
                            peek[1]-=order[1];
                            break;
                        }else{
                            buy.poll();
                            break;
                        }
                    } else {
                        sell.add(order);
                        break;
                    }
                }
            }
        }
        long res=0;
        int mod=1000000007;
        for(int[] order:sell){
            res=(res+order[1])%mod;
        }
        for(int[] order:buy){
            res=(res+order[1])%mod;
        }
        return (int) res;
    }
}
