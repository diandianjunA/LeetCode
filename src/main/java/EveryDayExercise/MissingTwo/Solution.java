package EveryDayExercise.MissingTwo;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] missingTwo(int[] nums) {
        int[] temp = new int[2];
        int[] res=new int[2];
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i])-1<nums.length){
                nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
            }else{
                temp[j++]=nums[i];
            }
        }
        j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                res[j++]=i+1;
            }
        }
        if(j==2){
            return res;
        }
        if(Math.abs(temp[0])!=nums.length+1){
            res[j++]=nums.length+1;
        }
        if(Math.abs(temp[0])!=nums.length+2&&Math.abs(temp[1])!=nums.length+2){
            res[j++]=nums.length+2;
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums={1};
        System.out.println(Arrays.toString(missingTwo(nums)));
    }
}
class Solution2 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;  //数组原本的长度
        int cur = n * (1 + n) / 2;  //数组原本的总和，根据等差数列求和公式得出
        for (int x : nums) cur -= x;  //cur为缺失的两个数的和
        int sum = cur;
        int t = cur / 2;  //t为缺失的两个数的和的一半
        cur = t * (1 + t) / 2;  //求数组[1, t]的理论总和
        for (int x : nums) {  //求数组[1, t]的实际总和，理论与实际之差即缺失两数之一
            if (x <= t) cur -= x;
        }
        return new int[]{cur, sum - cur};
    }
}
class Solution3{
    public int[] missingTwo(int[] nums){
        int n=0;
        for (int i = 0; i < nums.length; i++) {
            n=n^nums[i];
        }
        for (int i = 1; i <= nums.length+2; i++) {
            n=n^i;
        }
        //得到最低位的1，也就是这两个数不同的那一位
        int lowBit=n&(-n);
        int one=0;
        //重新异或一遍，将其中那个该位为0的数排除排除
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&lowBit)>0){
                one=one^nums[i];
            }
        }
        for (int i = 1; i <= nums.length + 2; i++) {
            if((i&lowBit)>0){
                one=one^i;
            }
        }
        return new int[]{one,n^one};
    }
}