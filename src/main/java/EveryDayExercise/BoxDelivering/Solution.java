package EveryDayExercise.BoxDelivering;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] weight = new int[boxes.length+1];
        int[] distance=new int[boxes.length+1];
        weight[1]=boxes[0][1];
        distance[0]=0;
        for (int i = 2; i <= boxes.length; i++) {
            weight[i]=weight[i-1]+boxes[i-1][1];
            if(boxes[i-1][0]!=boxes[i-2][0]){
                distance[i-1]=distance[i-2]+1;
            }else{
                distance[i-1]=distance[i-2];
            }
        }
        distance[boxes.length]=distance[boxes.length-1];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        int[] f = new int[boxes.length+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0]=0;
        for (int i = 1; i <= boxes.length; i++) {
            int j=Math.max(0,i-maxBoxes);
            while(j<i&&weight[i]-weight[j]>maxWeight){
                j++;
            }
            while(!deque.isEmpty()&&deque.peekFirst()<j){
                deque.pollFirst();
            }
            Integer peek = deque.peek();
            f[i]=Math.min(f[i],f[peek]+distance[i-1]-distance[peek]+2);
            while(!deque.isEmpty()&&f[deque.peekLast()]-distance[deque.peekLast()]>=f[i]-distance[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return f[boxes.length];
    }

    @Test
    public void test1(){
        int[][] boxes={{1,1},{2,1},{1,1}};
        int portsCount=2;
        int maxBoxes=3;
        int maxWeight=3;
        System.out.println(boxDelivering(boxes,portsCount,maxBoxes,maxWeight));
    }

    @Test
    public void test2(){
        int[][] boxes={{1,2},{3,3},{3,1},{3,1},{2,4}};
        int portsCount=3;
        int maxBoxes=3;
        int maxWeight=6;
        System.out.println(boxDelivering(boxes,portsCount,maxBoxes,maxWeight));
    }

    @Test
    public void test3(){
        int[][] boxes={{1,4},{1,2},{2,1},{2,1},{3,2},{3,4}};
        int portsCount=3;
        int maxBoxes=6;
        int maxWeight=7;
        System.out.println(boxDelivering(boxes,portsCount,maxBoxes,maxWeight));
    }

    @Test
    public void test4(){
        int[][] boxes={{2,4},{2,5},{3,1},{3,2},{3,7},{3,1},{4,4},{1,3},{5,2}};
        int portsCount=5;
        int maxBoxes=5;
        int maxWeight=7;
        System.out.println(boxDelivering(boxes,portsCount,maxBoxes,maxWeight));
    }
}
