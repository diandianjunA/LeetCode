package DataStructureLearningPlan.MergeIntervals;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<int[]> resTemp = new ArrayList<>();
        boolean flag=false;
        boolean flag1=true;
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0]==0&&intervals[i][1]!=0){
                flag1=false;
            }
            if(intervals[i][1]==0&&intervals[i][0]==0){
                flag=true;
            }else{
                temp.add(intervals[i][0]);
                temp.add(-intervals[i][1]);
            }
        }
        Collections.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)>Math.abs(o2)){
                    return 1;
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    if(o1>o2){
                        return -1;
                    }else if(o1==o2){
                        return 0;
                    }else{
                        return 1;
                    }
                }else{
                    return -1;
                }
            }
        });
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i)>=0){
                stack.push(temp.get(i));
                i++;
                int index = temp.get(i-1);
                while(!stack.isEmpty()){
                    if(temp.get(i)>=0){
                        stack.push(temp.get(i));
                    }else{
                        index=stack.pop();
                    }
                    i++;
                }
                i--;
                int[] arr = new int[2];
                arr[0]=index;
                arr[1]=-temp.get(i);
                resTemp.add(arr);
            }
        }
        int[][] res;
        if(flag1){
            if (flag){
                res = new int[resTemp.size()+1][2];
            }else {
                res = new int[resTemp.size()][2];
            }
        }else{
            res = new int[resTemp.size()][2];
        }
        int i=0;
        if(flag1){
            if(flag){
                int[] arr = new int[2];
                res[i++]=arr;
            }
        }
        for (int[] arr:resTemp){
            res[i++]=arr;
        }
        return res;
    }
    @Test
    public void test(){
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    @Test
    public void test2(){
        int[][] intervals={{1,4},{4,5}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    @Test
    public void test3(){
        int[][] intervals={{1,4},{0,2},{3,5}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    @Test
    public void test4(){
        int[][] intervals={{2,3},{4,5},{6,7},{8,9},{1,10}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    @Test
    public void test5(){
        int[][] intervals={{1,4},{0,0}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    @Test
    public void test6(){
        int[][] intervals={{1,3},{0,2},{2,3},{4,6},{4,5},{5,5},{0,2},{3,3}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    @Test
    public void test7(){
        int[] arr={1,4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test8(){
        int[][] intervals={{0,2},{2,3},{4,4},{0,1},{5,7},{4,5},{0,0}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
class Solution3 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }
}