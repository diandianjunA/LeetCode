package EveryDayExercise.MinOperationsNum;

import org.junit.Test;

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        // 先进行极限判断
        if(6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) return -1;
        // 看两个数组的差值
        int diff = 0;
        for(int x: nums2) diff += x;
        for(int x: nums1) diff -= x;
        // 判断哪个数组的总和大
        if(diff < 0){
            diff = -diff;
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        // 将nums1变为是小的一方
        int[] cnt = new int[6]; // 定义最大改变量为i的个数有多少个， 比如 5 如果要减少，最大能减少到1， 则 cnt[5 - 1] ++
        // 将小的数组，增多，大的数组减少
        for(int x: nums1) cnt[6 - x] ++;// 小的数组，最大只能到6
        for(int x: nums2) cnt[x - 1] ++; // 大的数组，最小只能到1
        for(int i = 5, ans = 0; i >= 1; i --){ // 从变化最大的开始
            if(i * cnt[i] >= diff){ // 如果当前总的变化和大于diff，说明当前操作可以让diff成为0
                return ans + (diff + i - 1) / i; // diff / i 的向上取整， 如diff = 10, i = 3, 则 diff + i - 1 / i = 4
            }
            diff -= i * cnt[i]; // 看下一个
            ans += cnt[i]; // 记录下当前变化的次数
        }
        return -1;
    }
    @Test
    public void test1(){
        int[] nums1={1,2,3,4,5,6};
        int[] nums2={1,1,2,2,2,2};
        System.out.println(minOperations(nums1,nums2));
    }

    @Test
    public void test2(){
        int[] nums1={1,1,1,1,1,1,1};
        int[] nums2={6};
        System.out.println(minOperations(nums1,nums2));
    }

    @Test
    public void test3(){
        int[] nums1={6,6};
        int[] nums2={1};
        System.out.println(minOperations(nums1,nums2));
    }

    @Test
    public void test4(){
        int[] nums1={6};
        int[] nums2={5,4,1,2,5,3,2,5,1,5,6,6,3,6,1,6};
        System.out.println(minOperations(nums1,nums2));
    }
}
