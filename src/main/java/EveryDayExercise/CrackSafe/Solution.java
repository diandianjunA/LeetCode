package EveryDayExercise.CrackSafe;

import org.junit.Test;

import java.util.*;

public class Solution {
    HashSet<String> points = new HashSet<>();
    HashSet<String> edges=new HashSet<>();
    StringBuilder res=new StringBuilder();
    int length;
    public String crackSafe(int n, int k) {
        length=k;
        for (int i = 0; i < k; i++) {
            StringBuilder cur = new StringBuilder(i);
            create(cur,n,k);
        }
        StringBuilder point = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            point.append(0);
        }
        dfs(point.toString());
        return res.append("0".repeat(n-1)).toString();
    }
    public void create(StringBuilder pre,int n,int k){
        if(pre.length()==n-1){
            points.add(pre.toString());
            return;
        }
        for (int i = 0; i < k; i++) {
            StringBuilder cur = new StringBuilder(pre);
            cur.append(i);
            create(cur,n,k);
        }
    }

    public void dfs(String point){
        for (int i = 0; i < length; i++) {
            String edge = point + i;
            if(edges.add(edge)){
                dfs(edge.substring(1));
                res.append(i);
            }
        }
    }

    @Test
    public void test1(){
        int n=1;
        int k=2;
        System.out.println(crackSafe(n,k));
    }

    @Test
    public void test2(){
        int n=2;
        int k=2;
        System.out.println(crackSafe(n,k));
    }

    @Test
    public void test3(){
        int n=3;
        int k=5;
        System.out.println(crackSafe(n,k));
    }

    @Test
    public void test4(){
        int n=2;
        int k=1;
        System.out.println(crackSafe(n,k));
    }
}
class Solution2 {
    private Set<Integer> vis = new HashSet<>();
    private StringBuilder ans = new StringBuilder();
    private int mod;

    public String crackSafe(int n, int k) {
        mod = (int) Math.pow(10, n - 1);
        dfs(0, k);
        ans.append("0".repeat(n - 1));
        return ans.toString();
    }

    private void dfs(int u, int k) {
        for (int x = 0; x < k; ++x) {
            int e = u * 10 + x;
            if (vis.add(e)) {
                int v = e % mod;
                dfs(v, k);
                ans.append(x);
            }
        }
    }
}