package EveryDayExercise.DistanceLimitedPathsExist;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < index.length; i++) {
            index[i]=i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return queries[o1][2]-queries[o2][2];
            }
        });
        Disjoint disjoint = new Disjoint(n);
        int k=0;
        boolean[] res = new boolean[queries.length];
        for(Integer query:index){
            while(k<edgeList.length&&edgeList[k][2]<queries[query][2]){
                disjoint.merge(edgeList[k][0],edgeList[k][1]);
                k++;
            }
            res[query]=disjoint.isConnected(queries[query][2],queries[query][2]);
        }
        return res;
    }
}

class Disjoint{
    int n;
    int[] father;
    int[] rank;

    public Disjoint(int n){
        this.n=n;
        father=new int[n];
        rank=new int[n];
        for (int i = 0; i < n; i++) {
            father[i]=i;
            rank[i]=1;
        }
    }

    public int findRoot(int x){
        if(father[x]==x){
            return x;
        }else{
            father[x]=findRoot(father[x]);
            return father[x];
        }
    }

    public void merge(int x,int y){
        int root1 = findRoot(x);
        int root2 = findRoot(y);
        if(rank[root1]>rank[root2]){
            father[root2]=root1;
        }else if(rank[root1]<rank[root2]){
            father[root1]=root2;
        }else{
            father[root2]=root1;
            rank[root1]++;
        }
    }

    public boolean isConnected(int x, int y){
        return findRoot(x)==findRoot(y);
    }
}