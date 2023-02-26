package EveryDayExercise.MatrixRankTransform;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        //将矩阵中的元素按大小排序，大小相同的元素放在一起
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(map.containsKey(matrix[i][j])){
                    List<int[]> list = map.get(matrix[i][j]);
                    list.add(new int[]{i,j});
                }else{
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[]{i,j});
                    map.put(matrix[i][j],list);
                }
            }
        }
        //用于记录每一行的最大值和每一列的最大值
        int[] rowMax = new int[matrix.length];
        int[] colMax = new int[matrix[0].length];
        //用于返回的答案
        int[][] answer = new int[matrix.length][matrix[0].length];
        //创建一个并查集
        disjoint disjoint = new disjoint(matrix.length + matrix[0].length);
        //创建一个秩的集合
        int[] rank=new int[matrix.length+matrix[0].length];
        //从小到大依次遍历每一个值
        for(Map.Entry<Integer,List<int[]>> entry:map.entrySet()){
            //将这个值对应的点所在的行和列加入并查集并关联起来
            //如果值相同的点有在同一行或者同一列的话，就会被并查集关联起来，它们的秩在后面也会关联起来
            for (int[] point : entry.getValue()) {
                disjoint.merge(point[0],point[1]+matrix.length);
            }
            for (int[] point : entry.getValue()) {
                int i=point[0];
                int j=point[1];
                //找到这个点在并查集中对应的一个连通区域，并找这个区域的最大秩（因为这个秩要使得区域内每个点都要合法，同时每个点在行上和列上的秩也要合法，所以行列最大值之间也要取最大值）
                rank[disjoint.find(i)]=Math.max(rank[disjoint.find(i)],Math.max(rowMax[i],colMax[j]));
            }
            for (int[] point : entry.getValue()) {
                int i=point[0];
                int j=point[1];
                //该点所在区域的秩已经求出
                answer[i][j]=rank[disjoint.find(i)]+1;
                //由于是按顺序遍历的，所以该点一定是该行该列上的最大值
                rowMax[i]=answer[i][j];
                colMax[j]=answer[i][j];
            }
            for (int[] point : entry.getValue()) {
                //把所有关联的行和列都从并查集中删除，以免影响下一轮的使用
                disjoint.reset(point[0]);
                disjoint.reset(point[1]+matrix.length);
            }
        }
        return answer;
    }

    @Test
    public void test1(){
        int[][] matrix={{1,2},{3,4}};
        System.out.println(Arrays.deepToString(matrixRankTransform(matrix)));
    }

    @Test
    public void test2(){
        int[][] matrix={{7,7},{7,7}};
        System.out.println(Arrays.deepToString(matrixRankTransform(matrix)));
    }

    @Test
    public void test3(){
        int[][] matrix={{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}};
        System.out.println(Arrays.deepToString(matrixRankTransform(matrix)));
    }
}
class disjoint{
    int n;
    int[] fa;
    int[] rank;

    public disjoint(int n) {
        this.n = n;
        fa=new int[n];
        rank=new int[n];
        for (int i = 0; i < n; i++) {
            fa[i]=i;
            rank[i]=1;
        }
    }

    public int find(int i){
        if(fa[i]!=i){
            fa[i]=find(fa[i]);
        }
        return fa[i];
    }

    public void merge(int x,int y){
        int i = find(x);
        int j = find(y);
        if(i!=j){
            if(rank[i]>rank[j]){
                fa[j]=i;
            }else if(rank[i]<rank[j]){
                fa[i]=j;
            }else{
                fa[j]=i;
                rank[i]++;
            }
        }
    }

    public void reset(int x){
        fa[x]=x;
        rank[x]=1;
    }
}