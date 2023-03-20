package FirstPackage.CombinationSum2;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return deal(candidates,target,0);
    }

    public List<List<Integer>> deal(int[] candidates, int target,int i) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(target<0){
            return res;
        }
        if(target==0){
            res.add(new ArrayList<>());
            return res;
        }
        for (int j = i; j < candidates.length; j++) {
            if(j>i&&candidates[j]==candidates[j-1]){
                continue;
            }
            List<List<Integer>> deal = deal(candidates, target - candidates[j], j + 1);
            if(!deal.isEmpty()){
                for(List<Integer> list:deal){
                    list.add(candidates[j]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean checkEquals(List<Integer> list1,List<Integer> list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if(!Objects.equals(list1.get(i), list2.get(i))){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(candidates,target));
    }

    @Test
    public void test2(){
        int[] candidates={2,5,2,1,2};
        int target=5;
        System.out.println(combinationSum2(candidates,target));
    }

    @Test
    public void test3(){
        int[] candidates={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target=30;
        System.out.println(combinationSum2(candidates,target));
    }
}