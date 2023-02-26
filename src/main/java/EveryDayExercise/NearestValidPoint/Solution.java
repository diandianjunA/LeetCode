package EveryDayExercise.NearestValidPoint;

public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int distance=Integer.MAX_VALUE;
        int res=-1;
        for (int i = 0; i < points.length; i++) {
            if(points[i][0]==x||points[i][1]==y){
                int m=Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(m<distance){
                    distance=m;
                    res=i;
                }
            }
        }
        return res;
    }
}
