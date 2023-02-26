package EveryDayExercise.MaxAverageRatio;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double d1=(o1[0]+1)*1.0/(o1[1]+1)-o1[0]*1.0/o1[1];
                double d2=(o2[0]+1)*1.0/(o2[1]+1)-o2[0]*1.0/o2[1];
                return -Double.compare(d1, d2);
            }
        });
        for (int i = 0; i < classes.length; i++) {
            priorityQueue.offer(classes[i]);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = priorityQueue.poll();
            poll[0]++;
            poll[1]++;
            priorityQueue.offer(poll);
        }
        double res=0;
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            if(poll[0]<=poll[1]){
                res+=poll[0]*1.0/poll[1];
            }else {
                res+=1;
            }
        }
        return res/classes.length;
    }

    @Test
    public void test1(){
        int[][] classes={{1,2},{3,5},{2,2}};
        int extraStudent=2;
        System.out.println(maxAverageRatio(classes,extraStudent));
    }
}
