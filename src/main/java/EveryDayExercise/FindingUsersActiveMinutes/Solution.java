package EveryDayExercise.FindingUsersActiveMinutes;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        map.put(logs[0][0],1);
        for (int i = 1; i < logs.length; i++) {
            if(logs[i][0]==logs[i-1][0]&&logs[i][1]==logs[i-1][1]){
                continue;
            }
            map.put(logs[i][0],map.getOrDefault(logs[i][0],0)+1);
        }
        int[] answer = new int[k];
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            answer[entry.getValue()-1]++;
        }
        return answer;
    }

    @Test
    public void test1(){
        int[][] logs={{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k=5;
        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs, k)));
    }

    @Test
    public void test2(){
        int[][] logs={{1,1},{2,2},{2,3}};
        int k=4;
        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs, k)));
    }

    @Test
    public void test3(){
        int[][] logs={{409246005,142},{409246002,144},{409246001,143},{409246000,141},{409246000,139},{409246000,144},{409246004,139},{409246003,144},{409246001,142}};
        int k=8;
        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs, k)));
    }
}
