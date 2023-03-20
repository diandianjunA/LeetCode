package WeekCompetition337.FindSmallestInteger;

import org.junit.Test;

import java.util.*;

/**
 * 超时
 */
public class Solution {

    public int findSmallestInteger(int[] nums, int value) {
        if(value==1){
            return nums.length;
        }
        int res=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while(true){
            if(list.contains(res)){
                list.remove((Integer) res);
                res++;
                continue;
            }
            boolean has=false;
            for (int i = 0; i < list.size(); i++) {
                if((res-list.get(i))%value==0){
                    list.remove(i);
                    res++;
                    has=true;
                    break;
                }
            }
            if(!has){
                return res;
            }
        }
    }

    @Test
    public void test1(){
        int[] nums={1,-10,7,13,6,8};
        int value=5;
        System.out.println(Solution2.findSmallestInteger(nums,value));
    }

    @Test
    public void test2(){
        int[] nums={1,-10,7,13,6,8};
        int value=7;
        System.out.println(findSmallestInteger(nums,value));
    }

    @Test
    public void test3(){
        int[] nums={3,0,3,2,4,2,1,1,0,4};
        int value=5;
        System.out.println(Solution2.findSmallestInteger(nums,value));
    }

    @Test
    public void test4(){
        int[] nums={3,0,3,2,4,2,1,1,0,4};
        int value=5;
        System.out.println(findSmallestInteger(nums,value));
    }

    @Test
    public void test5(){
        int[] nums={0,0,0,0,0,0,0,0,0,0};
        int value=1;
        System.out.println(findSmallestInteger(nums,value));
    }

    @Test
    public void test6(){
        int[] nums={0,-3};
        int value=4;
        System.out.println(Solution2.findSmallestInteger(nums,value));
    }
}

class Solution2 {
    public static int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                nums[i]=nums[i]-(nums[i]/value-1)*value;
            }
            map.put(nums[i]%value,map.getOrDefault(nums[i]%value,0)+1);
        }
        int res=0;
        while(true){
            if(map.containsKey(res%value)){
                Integer integer = map.get(res % value);
                if(integer==1){
                    map.remove(res%value);
                }else{
                    map.put(res%value,integer-1);
                }
                res++;
            }else{
                return res;
            }
        }
    }
}