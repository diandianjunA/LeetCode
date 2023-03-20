package PracticePackage.MaxOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 超时
 */
public class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        int[][] map = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0]][edges[i][1]]=1;
            map[edges[i][1]][edges[i][0]]=1;
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int dfs = dfs(i, visited, map,price);
            if(dfs-price[i]>max){
                max=dfs-price[i];
            }
        }
        return max;
    }

    public int dfs(int i,boolean[] visited,int[][] map,int[] price){
        int max=price[i];
        visited[i]=true;
        for (int j = 0; j < map[i].length; j++) {
            if(!visited[j]&&map[i][j]==1){
                int dfs = dfs(j, visited, map,price)+price[i];
                if(dfs>max){
                    max=dfs;
                }
            }
        }
        return max;
    }
}

class Solution2 {
    private List<Integer>[] g;
    private int[] price;
    private long ans;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建树
        }
        dfs(0, -1);
        return ans;
    }

    // 返回带叶子的最大路径和，不带叶子的最大路径和
    private long[] dfs(int x, int fa) {
        long p = price[x], maxS1 = p, maxS2 = 0;
        for (var y : g[x])
            if (y != fa) {
                var res = dfs(y, x);
                long s1 = res[0], s2 = res[1];
                // 前面最大带叶子的路径和 + 当前不带叶子的路径和
                // 前面最大不带叶子的路径和 + 当前带叶子的路径和
                ans = Math.max(ans, Math.max(maxS1 + s2, maxS2 + s1));
                maxS1 = Math.max(maxS1, s1 + p);
                maxS2 = Math.max(maxS2, s2 + p); // 这里加上 p 是因为 x 必然不是叶子
            }
        return new long[]{maxS1, maxS2};
    }
}