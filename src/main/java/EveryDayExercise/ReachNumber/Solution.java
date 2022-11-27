package EveryDayExercise.ReachNumber;

import org.junit.Test;

public class Solution {
    public int reachNumber(int target) {
        return reach(Math.abs(target),1,0);
    }

    public int reach(int target,int step,int total){
        if(total+step==target){
            return step;
        } else if (total - step == target) {
            return step;
        } else if (total + step > target) {
            if((total+step-target)%2==0){
                return step;
            }else{
                if((step+1)%2==0){
                    return step+2;
                }else{
                    return step+1;
                }
            }
        }else{
            return reach(target,step+1,total+step);
        }
    }

    @Test
    public void test1(){
        System.out.println(reachNumber(2));
    }

    @Test
    public void test2(){
        System.out.println(reachNumber(3));
    }

    @Test
    public void test3(){
        System.out.println(reachNumber(-1));
    }

    @Test
    public void test4(){
        System.out.println(reachNumber(-2));
    }

    @Test
    public void test5(){
        System.out.println(reachNumber(4));
    }
}
class Solution2 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}