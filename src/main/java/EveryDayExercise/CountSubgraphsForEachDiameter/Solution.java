package EveryDayExercise.CountSubgraphsForEachDiameter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] res = new int[n - 1];
        int[][] loc = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            loc[edges[i][0]-1][edges[i][1]-1]=1;
            loc[edges[i][1]-1][edges[i][0]-1]=1;
        }
        for (int i = 1; i <= n - 1; i++) {
            ArrayList<Integer> totalPath = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                res[i-1]+=search(loc,0,i,j,1<<j,totalPath);
            }
        }
        return res;
    }

    public int search(int[][] loc, int layer, int maxLayer, int cur,int curPath,List<Integer> totalPath){
        if(layer==maxLayer){
            if(totalPath.contains(curPath)){
                return 0;
            }else{
                totalPath.add(curPath);
                return 1;
            }
        }
        int res=0;
        for (int i = 0; i < loc.length; i++) {
            if(((curPath&(1<<i))==0)&&loc[cur][i]!=0){
                res+=search(loc, layer+1, maxLayer, i,curPath|(1<<i),totalPath);
            }
        }
        return res;
    }

    @Test
    public void test1(){
        int n=4;
        int[][] edge={{1,2},{2,3},{2,4}};
        System.out.println(Arrays.toString(countSubgraphsForEachDiameter(n,edge)));
    }
}

class Solution2 {
    int mask;
    int diameter;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        int[] ans = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            int root = 32 - Integer.numberOfLeadingZeros(i) - 1;
            mask = i;
            diameter = 0;
            dfs(root, adj);
            if (mask == 0 && diameter > 0) {
                ans[diameter - 1]++;
            }
        }
        return ans;
    }

    public int dfs(int root, List<Integer>[] adj) {
        int first = 0, second = 0;
        mask &= ~(1 << root);
        for (int vertex : adj[root]) {
            if ((mask & (1 << vertex)) != 0) {
                mask &= ~(1 << vertex);
                int distance = 1 + dfs(vertex, adj);
                if (distance > first) {
                    second = first;
                    first = distance;
                } else if (distance > second) {
                    second = distance;
                }
            }
        }
        diameter = Math.max(diameter, first + second);
        return first;
    }
}