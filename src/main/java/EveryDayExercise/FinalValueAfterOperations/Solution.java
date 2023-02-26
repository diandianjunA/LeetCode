package EveryDayExercise.FinalValueAfterOperations;

public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for (String operation : operations) {
            res += operation(operation);
        }
        return res;
    }
    public int operation(String op){
        switch (op){
            case "X++":
            case "++X":
                return 1;
            case "X--":
            case "--X":
                return -1;
        }
        return 0;
    }
}