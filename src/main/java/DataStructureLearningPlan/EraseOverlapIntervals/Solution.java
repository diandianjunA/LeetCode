package DataStructureLearningPlan.EraseOverlapIntervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }else if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return -1;
                }
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] temp:intervals){
            check(list,temp);
        }
        return intervals.length-list.size();
    }
    public void check(ArrayList<int[]> list,int[] temp){
        if(list.isEmpty()){
            list.add(temp);
            return;
        }
        int i=0,index=0;
        boolean flag=false;
        for (int[] interval:list){
            if(!(interval[0]>=temp[1]||interval[1]<=temp[0])){
                if(interval[1]<=temp[1]){
                    return;
                }else{
                    flag=true;
                    index=i;
                }
            }
            i++;
        }
        if(flag){
            list.remove(index);
        }
        list.add(temp);
    }
    @Test
    public void test(){
        int[][] intervals={{0,2},{1,3},{2,4},{3,5},{4,6}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
class Solution3 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}