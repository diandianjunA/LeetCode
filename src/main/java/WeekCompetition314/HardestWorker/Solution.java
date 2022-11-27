package WeekCompetition314.HardestWorker;

public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int longestTime=logs[0][1];
        int id=logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int time = logs[i][1] - logs[i - 1][1];
            if(time>longestTime){
                longestTime=time;
                id=logs[i][0];
            } else if (time == longestTime) {
                if(logs[i][0]<id){
                    id=logs[i][0];
                }
            }
        }
        return id;
    }
}
