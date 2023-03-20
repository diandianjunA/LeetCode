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

class Solution3 {
    private List<Integer>[] g;
    private boolean[] inSet, vis;
    private int[] ans;
    private int n, diameter;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0] - 1, y = e[1] - 1; // 编号改为从 0 开始
            g[x].add(y);
            g[y].add(x); // 建树
        }

        ans = new int[n - 1];
        inSet = new boolean[n];
        f(0);
        return ans;
    }

    private void f(int i) {
        if (i == n) {
            for (int v = 0; v < n; ++v)
                if (inSet[v]) {
                    vis = new boolean[n];
                    diameter = 0;
                    dfs(v);
                    break;
                }
            if (diameter > 0 && Arrays.equals(vis, inSet))
                ++ans[diameter - 1];
            return;
        }

        // 不选城市 i
        f(i + 1);

        // 选城市 i
        inSet[i] = true;
        f(i + 1);
        inSet[i] = false; // 恢复现场
    }

    // 求树的直径
    private int dfs(int x) {
        vis[x] = true;
        int maxLen = 0;
        for (int y : g[x])
            if (!vis[y] && inSet[y]) {
                int ml = dfs(y) + 1;
                diameter = Math.max(diameter, maxLen + ml);
                maxLen = Math.max(maxLen, ml);
            }
        return maxLen;
    }
}