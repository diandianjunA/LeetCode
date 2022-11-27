package WeekCompetition312.NumberOfGoodPaths;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int res=vals.length;
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if(edges[j][0]==vals[i]){
                    res+=isGoodPaths(vals,edges,i,edges[i][1]);
                }
                if(edges[j][1]==vals[i]){
                    res+=isGoodPaths(vals,edges,i,edges[i][0]);
                }
            }
        }
        return res;
    }
    public int isGoodPaths(int[] vals,int[][] edges,int front,int index){
        if(index>=vals.length){
            return 0;
        }
        int res=0;
        if(vals[index]==vals[front]){
            res++;
        }else if(vals[index]>vals[front]){
            return 0;
        }else{
            for (int i = 0; i < edges.length; i++) {
                if(edges[i][0]==vals[index]){
                    res+=isGoodPaths(vals,edges,front,edges[i][1]);
                }
                if(edges[i][1]==vals[index]){
                    res+=isGoodPaths(vals,edges,front,edges[i][0]);
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[] vals = {1, 3, 2, 1, 3};
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        System.out.println(numberOfGoodPaths(vals,edges));
    }
}
class Solution2 {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Arrays.sort(edges, (o, p) -> Math.max(vals[o[0]], vals[o[1]]) - Math.max(vals[p[0]], vals[p[1]]));
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.computeIfAbsent(vals[i], t -> new ArrayList<>()).add(i);
        }
        UF uf = new UF(vals.length);
        int result = 0, i = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for (; i < edges.length && Math.max(vals[edges[i][0]], vals[edges[i][1]]) == entry.getKey(); i++) {
                uf.union(edges[i][0], edges[i][1]);
            }
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int j : entry.getValue()) {
                count.put(uf.find(j), count.getOrDefault(uf.find(j), 0) + 1);
                result += count.get(uf.find(j));
            }
        }
        return result;
    }

    class UF {
        private int[] parent, rank;

        private UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (rank[rootP] < rank[rootQ])
                parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ])
                parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }
}
