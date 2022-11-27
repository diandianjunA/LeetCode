package EveryDayExercise;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        return isOrdered(arr,pieces,0);
    }
    public boolean isOrdered(int[] arr,int[][] pieces,int index){
        if(index==pieces.length){
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==pieces[index][0]){
                int k=0;
                while(k<pieces[index].length&&i+k<arr.length){
                    if(arr[i+k]!=pieces[index][k]){
                        return false;
                    }
                    k++;
                }
                if(k==pieces[index].length){
                    return isOrdered(arr,pieces,index+1);
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    public boolean canFormArrayPro(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < n;) {
            if (!index.containsKey(arr[i])) {
                return false;
            }
            int j = index.get(arr[i]), len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;
    }
    @Test
    public void test(){
        int[] arr={91,4,64,78};
        int[][] piece={{78},{4,64},{91}};
        System.out.println(canFormArray(arr,piece));
    }
}
