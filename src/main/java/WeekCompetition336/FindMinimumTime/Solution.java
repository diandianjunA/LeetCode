package WeekCompetition336.FindMinimumTime;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
    public int findMinimumTime(int[][] tasks) {
        int[] map = new int[2000];
        Integer[] sort = new Integer[2000];
        for (int i = 0; i < tasks.length; i++) {
            for (int j = tasks[i][0]; j <= tasks[i][1]; j++) {
                map[j-1]++;
            }
        }
        for (int i = 0; i < 2000; i++) {
            sort[i]=i;
        }
        Arrays.sort(sort, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(map[o1]-map[o2]);
            }
        });
        int res=0;
        boolean[] delete = new boolean[2000];
        while(true){
            if(map[sort[0]]<=0){
                return res;
            }else{
                res++;
                for (int i = 0; i < tasks.length; i++) {
                    if(sort[0]+1>=tasks[i][0]&&sort[0]+1<=tasks[i][1]&&tasks[i][2]!=0){
                        if(tasks[i][2]==1){
                            tasks[i][2]--;
                            for (int j = tasks[i][0]; j <= tasks[i][1]; j++) {
                                if(!delete[j-1]){
                                    map[j-1]--;
                                }
                            }
                        }else{
                            tasks[i][2]--;
                            if(!delete[sort[0]]){
                                map[sort[0]]--;
                            }
                        }
                    }
                }
                delete[sort[0]]=true;
                Arrays.sort(sort, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return -(map[o1]-map[o2]);
                    }
                });
            }
        }
    }

    @Test
    public void test1(){
        int[][] task={{2,3,1},{4,5,1},{1,5,2}};
        System.out.println(findMinimumTime(task));
    }

    @Test
    public void test2(){
        int[][] task={{1,3,2},{2,5,3},{5,6,2}};
        System.out.println(findMinimumTime(task));
    }

    @Test
    public void test3(){
        int[][] task={{68,129,2},{58,86,9},{112,142,10},{106,108,1},{48,48,1},{116,143,2},{28,43,5},{1,1,1},{75,83,3},{104,136,10},{11,11,1},{60,63,1},{73,111,8},{57,57,1},{117,119,3},{25,38,2},{20,21,1},{78,80,2},{17,17,1},{28,28,1},{77,117,3},{76,109,4},{61,61,1},{84,92,5},{18,41,4},{47,55,9},{74,132,6},{53,87,3},{102,131,7},{26,26,1},{66,68,3},{59,73,1},{22,30,9},{9,13,2},{31,35,2},{90,91,2},{72,72,1},{62,84,8},{105,106,2},{3,3,1},{32,32,1},{99,103,4},{45,52,4},{108,116,3},{91,123,8},{89,114,4},{94,130,7},{103,104,2},{14,17,4},{63,66,4},{98,112,7},{101,140,9},{58,58,1},{109,145,1},{8,15,8},{4,16,5},{115,141,1},{40,50,4},{118,118,1},{81,120,7}};
        System.out.println(findMinimumTime(task));
    }
}

class Solution2 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int ans = 0;
        var run = new boolean[tasks[tasks.length - 1][1] + 1];
        for (var t : tasks) {
            int start = t[0], end = t[1], d = t[2];
            for (int i = start; i <= end; ++i)
                if (run[i]) --d;  // 去掉运行中的时间点
            for (int i = end; d > 0; --i) // 剩余的 d 填充区间后缀
                if (!run[i]) {
                    run[i] = true;
                    --d;
                    ++ans;
                }
        }
        return ans;
    }
}