package EveryDayExercise.ValidPath;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Disjoint disjoint = new Disjoint(n);
        for (int[] edge : edges) {
            disjoint.merge(edge[0], edge[1]);
        }
        return disjoint.isConnected(source,destination);
    }
}

class Disjoint{
    int n;
    int[] f;
    int[] rank;

    public Disjoint(int n){
        this.n=n;
        f=new int[n];
        rank=new int[n];
        for (int i = 0; i < n; i++) {
            f[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x){
        if(f[x]==x){
            return x;
        }
        f[x]=find(f[x]);
        return f[x];
    }

    public void merge(int x,int y){
        int i=find(x);
        int j=find(y);
        if(rank[i]>rank[j]){
            f[j]=i;
        }else if(rank[j]>rank[i]){
            f[i]=j;
        }else{
            f[j]=i;
            rank[i]++;
        }
    }

    public boolean isConnected(int x,int y){
        return find(x)==find(y);
    }
}