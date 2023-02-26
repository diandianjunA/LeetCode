package EveryDayExercise.FindSolution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                int value = customfunction.f(i, j);
                if(value==z){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }else if(value>z){
                    break;
                }
            }
        }
        return res;
    }
}

class CustomFunction {
    public int f(int x, int y){
        return 0;
    }
};