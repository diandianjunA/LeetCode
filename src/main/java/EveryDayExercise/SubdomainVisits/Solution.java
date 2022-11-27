package EveryDayExercise.SubdomainVisits;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> firstDomains = new HashMap<>();
        HashMap<String, Integer> secondDomains = new HashMap<>();
        HashMap<String, Integer> thirdDomains = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");
            String[] split = s[1].split("\\.");
            if(split.length==3){
                String firstDomain=split[2];
                String secondDomain=split[1]+"."+split[2];
                String thirdDomain=split[0]+"."+split[1]+"."+split[2];
                firstDomains.put(firstDomain,Integer.parseInt(s[0])+firstDomains.getOrDefault(firstDomain,0));
                secondDomains.put(secondDomain,Integer.parseInt(s[0])+secondDomains.getOrDefault(secondDomain,0));
                thirdDomains.put(thirdDomain,Integer.parseInt(s[0])+thirdDomains.getOrDefault(thirdDomain,0));
            }else if(split.length==2){
                String firstDomain=split[1];
                String secondDomain=split[0]+"."+split[1];
                firstDomains.put(firstDomain,Integer.parseInt(s[0])+firstDomains.getOrDefault(firstDomain,0));
                secondDomains.put(secondDomain,Integer.parseInt(s[0])+secondDomains.getOrDefault(secondDomain,0));
            }else{
                String firstDomain=split[0];
                firstDomains.put(firstDomain,Integer.parseInt(s[0])+firstDomains.getOrDefault(firstDomain,0));
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String,Integer> entry:thirdDomains.entrySet()){
            res.add(entry.getValue()+" "+entry.getKey());
        }
        for (Map.Entry<String,Integer> entry:secondDomains.entrySet()){
            res.add(entry.getValue()+" "+entry.getKey());
        }
        for (Map.Entry<String,Integer> entry:firstDomains.entrySet()){
            res.add(entry.getValue()+" "+entry.getKey());
        }
        return res;
    }
    @Test
    public void test(){
        String[] domains={"9001 discuss.leetcode.com"};
        for (String subdomainVisit : subdomainVisits(domains)) {
            System.out.println(subdomainVisit);
        }

    }
}
