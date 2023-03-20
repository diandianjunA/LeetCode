package FirstPackage.CombinationSum;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(target<0){
            return res;
        }
        if(target==0){
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> lists = combinationSum(candidates, target - candidates[i]);
            if(!lists.isEmpty()){
                for(List<Integer> list:lists){
                    list.add(candidates[i]);
                    Collections.sort(list);
                    boolean has=false;
                    for(List<Integer> ls:res){
                        if(checkEquals(ls,list)){
                            has=true;
                            break;
                        }
                    }
                    if(!has){
                        res.add(list);
                    }
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
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates,target));
    }

    @Test
    public void test2(){
        int[] candidates={2,3,5};
        int target=8;
        System.out.println(combinationSum(candidates,target));
    }

    @Test
    public void test3(){
        int[] candidates={2};
        int target=1;
        System.out.println(combinationSum(candidates,target));
    }
}

class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }
}