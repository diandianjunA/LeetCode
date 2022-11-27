package EveryDayExercise.StockSpanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    List<Integer> prices;
    public StockSpanner() {
        prices=new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int size = prices.size()-1;
        while(size>=0&&prices.get(size)<=price){
            size--;
        }
        size++;
        return prices.size()-size;
    }
}
