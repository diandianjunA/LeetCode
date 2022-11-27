package AutumnCompetition.TransportationHub;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int transportationHub(int[][] path) {
        HashSet<Integer> location = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> outMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> inMap = new HashMap<>();
        for (int i = 0; i < path.length; i++) {
            if(outMap.containsKey(path[i][0])){
                outMap.get(path[i][0]).add(path[i][1]);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(path[i][1]);
                outMap.put(path[i][0],list);
            }
            if(inMap.containsKey(path[i][1])){
                inMap.get(path[i][1]).add(path[i][0]);
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(path[i][0]);
                inMap.put(path[i][1],list);
            }
            location.add(path[i][0]);
            location.add(path[i][1]);
        }
        int maxSize=0;
        ArrayList<Integer> maxKey = new ArrayList<>();
        for (Map.Entry<Integer,ArrayList<Integer>> entry:inMap.entrySet()){
            if(entry.getValue().size()>maxSize){
                maxKey.clear();
                maxKey.add(entry.getKey());
                maxSize=entry.getValue().size();
            } else if (entry.getValue().size() == maxSize) {
                maxKey.add(entry.getKey());
            }
        }
        if(maxSize<location.size()-1){
            return -1;
        }
        for (int i = 0; i < maxKey.size(); i++) {
            Integer key = maxKey.get(i);
            if(!outMap.containsKey(key)){
                return key;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[][] path={{0,3},{1,0},{1,3},{2,0},{3,0},{3,2}};
        System.out.println(transportationHub(path));
    }
}
