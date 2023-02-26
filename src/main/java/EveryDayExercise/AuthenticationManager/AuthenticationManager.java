package EveryDayExercise.AuthenticationManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AuthenticationManager {
    int timeToLive;
    HashMap<String,Integer> tokenList;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive=timeToLive;
        tokenList=new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenList.put(tokenId,currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if(tokenList.containsKey(tokenId)){
            Integer time = tokenList.get(tokenId);
            if(time+timeToLive>currentTime){
                tokenList.put(tokenId,currentTime);
            }else {
                tokenList.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res=0;
        for(Map.Entry<String,Integer> entry:tokenList.entrySet()){
            Integer time = entry.getValue();
            if(time+timeToLive>currentTime){
                res++;
            }
        }
        return res;
    }
}
