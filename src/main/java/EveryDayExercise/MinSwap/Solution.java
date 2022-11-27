package EveryDayExercise.MinSwap;

import org.junit.Test;

public class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        dp[0][0]=0;
        dp[0][1]=1;
        int changedLastNums1=nums2[0],changedLastNums2=nums1[0];
        for (int i = 1; i < nums1.length; i++) {
            if(nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                    dp[i][0]=dp[i-1][0];
                    dp[i][1]=dp[i-1][0]+1;
                }else{
                    dp[i][0]=dp[i-1][0];
                    dp[i][1]=Integer.MAX_VALUE;
                }
            }else {
                if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                    dp[i][0]=Integer.MAX_VALUE;
                    dp[i][1]=dp[i-1][0]+1;
                }else {
                    dp[i][0]=Integer.MAX_VALUE;
                    dp[i][1]=Integer.MAX_VALUE;
                }
            }
            if(nums1[i]>changedLastNums1&&nums2[i]>changedLastNums2){
                if(nums1[i]>changedLastNums2&&nums2[i]>changedLastNums1){
                    dp[i][0]=Math.min(dp[i][0],dp[i-1][1]);
                    dp[i][1]=Math.min(dp[i][1],dp[i-1][1]+1);
                }else{
                    dp[i][0]=Math.min(dp[i][0],dp[i-1][1]);
                }
            }else {
                if(nums1[i]>changedLastNums2&&nums2[i]>changedLastNums1){
                    dp[i][1]=Math.min(dp[i][1],dp[i-1][1]+1);
                }else {

                }
            }
            changedLastNums1=nums2[i];
            changedLastNums2=nums1[i];
        }
        return Math.min(dp[nums1.length-1][0],dp[nums1.length-1][1]);
    }
    @Test
    public void test(){
        int[] nums1={1,3,5,4};
        int[] nums2={1,2,3,7};
        System.out.println(minSwap(nums1,nums2));
    }
    @Test
    public void test1(){
        int[] nums1={0,3,5,8,9};
        int[] nums2={2,1,4,6,9};
        System.out.println(minSwap(nums1,nums2));
    }
    @Test
    public void test2(){
        int[] nums1={3,3,8,9,10};
        int[] nums2={1,7,4,6,8};
        System.out.println(minSwap(nums1,nums2));
    }
}
class Solution2 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1])  {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }
}
class Solution3 {
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        dp[0][0] = 0; dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // 如果i【不互换】，则i-1可【互换】也可【不互换】
                dp[i][1] = dp[i][0] + 1; // 如果i【互换】，则i-1可【互换】也可【不互换】
            } else if (a1 < a2 && b1 < b2) {
                dp[i][0] = dp[i - 1][0]; // 如果i【不互换】，则i-1必须【不互换】
                dp[i][1] = dp[i - 1][1] + 1; // 如果i【互换】，则i-1必须【互换】
            } else {
                dp[i][0] = dp[i - 1][1]; // 如果i【不互换】，则i-1必须【互换】
                dp[i][1] = dp[i - 1][0] + 1; // 如果i【互换】，则i-1必须【不互换】
            }
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }
}