package EveryDayExercise.AlertNames;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> list = map.get(keyName[i]);
            if(list==null){
                ArrayList<Integer> times = new ArrayList<>();
                String[] split = keyTime[i].split(":");
                int h = Integer.parseInt(split[0]);
                int m = Integer.parseInt(split[1]);
                times.add(h*60+m);
                map.put(keyName[i],times);
            }else {
                String[] split = keyTime[i].split(":");
                int h = Integer.parseInt(split[0]);
                int m = Integer.parseInt(split[1]);
                list.add(h*60+m);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry:map.entrySet()){
            List<Integer> value = entry.getValue();
            Collections.sort(value);
            for (int i = 0; i < value.size()-2; i++) {
                if(value.get(i+2)-value.get(i)<=60){
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    @Test
    public void test1(){
        String[] keyName={"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime={"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(alertNames(keyName,keyTime));
    }

    @Test
    public void test2(){
        String[] keyName={"alice","alice","alice","bob","bob","bob","bob"};
        String[] keyTime={"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
        System.out.println(alertNames(keyName,keyTime));
    }

    @Test
    public void test3(){
        String[] keyName={"john","john","john"};
        String[] keyTime={"23:58","23:59","00:01"};
        System.out.println(alertNames(keyName,keyTime));
    }

    @Test
    public void test4(){
        String[] keyName={"leslie","leslie","leslie","clare","clare","clare","clare"};
        String[] keyTime={"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};
        System.out.println(alertNames(keyName,keyTime));
    }
}
