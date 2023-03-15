package EveryDayExercise.MergeSimilarItems;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) + items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            ret.add(list);
        }
        Collections.sort(ret, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        return ret;
    }

    @Test
    public void test1(){
        int[][] items1={{1,5},{3,1}};
        int[][] items2={{1,1},{4,5},{3,8}};
        List<List<Integer>> lists = mergeSimilarItems(items1, items2);
        System.out.println(lists);
    }

    @Test
    public void test2(){
        int[][] items1={{3,2},{2,1},{1,3}};
        int[][] items2={{1,1},{2,3},{3,2}};
        List<List<Integer>> lists = mergeSimilarItems(items1, items2);
        System.out.println(lists);
    }

    @Test
    public void test3(){
        int[][] items1={{7,1},{2,2},{1,4}};
        int[][] items2={{2,2},{1,3}};
        List<List<Integer>> lists = mergeSimilarItems(items1, items2);
        System.out.println(lists);
    }
}
