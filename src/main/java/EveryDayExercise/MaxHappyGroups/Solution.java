package EveryDayExercise.MaxHappyGroups;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public HashMap<Integer,Integer> cache=new HashMap<>();

    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] mod = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            mod[i]=groups[i]%batchSize;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int res=0;
        for (int i = 0; i < mod.length; i++) {
            if(mod[i]==0){
                res++;
            }else{
                list.add(mod[i]);
            }
        }
        int mask=0;
        int[] cnt = new int[batchSize];
        for (int i = 0; i < list.size(); i++) {
            if(cnt[batchSize-list.get(i)]>0){
                cnt[batchSize-list.get(i)]--;
                res++;
            }else{
                cnt[list.get(i)]++;
            }
        }
        int n=0;
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i]>0){
                n++;
            }
        }
        int[] val = new int[n];
        n--;
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i]>0){
                val[n]=i;
                n--;
                mask=(mask<<5)|cnt[i];
            }
        }
        return res+dfs(mask,val,batchSize);
    }

    public int dfs(int mask,int[] val,int batchSize){
        if(cache.containsKey(mask)){
            return cache.get(mask);
        }
        int res=0;
        int left=mask>>20;
        int msk=mask&((1<<20)-1);
        for (int i = 0, j=0; i < val.length; i++,j=j+5) {
            if((mask&(31<<j))>0){
                res= Math.max(res,(left==0?1:0)+dfs((((left+val[i])%batchSize)<<20)+(msk-(1<<j)),val,batchSize));
            }
            cache.put(mask,res);
        }
        return res;
    }

    @Test
    public void test1(){
        int batchSize=3;
        int[] groups={1,2,3,4,5,6};
        System.out.println(maxHappyGroups(batchSize,groups));
    }

    @Test
    public void test2(){
        int batchSize=4;
        int[] groups={1,3,2,5,2,2,1,6};
        System.out.println(maxHappyGroups(batchSize,groups));
    }

    @Test
    public void test3(){
        int batchSize=2;
        int[] groups={916210963,37071830,515639792,260640057,798574708,856206295,434101040,444866270,713762924,185765287,394196213,589268180,947826294,754884266,833049335,724223643,792652821,402334308,92843871};
        System.out.println(maxHappyGroups(batchSize,groups));
    }

    @Test
    public void test4(){
        int batchSize=7;
        int[] groups={287773481,815094798,356732984,644469322,543193620,903158817,274116865,395252956,363839119,365378492,122313059,312690039,252532812};
        System.out.println(maxHappyGroups(batchSize,groups));
    }
}
