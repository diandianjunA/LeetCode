package EveryDayExercise.SumSubseqWidths;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int sumSubseqWidths(int[] nums) {
        int mod=1000000007;
        Arrays.sort(nums);
        long res=0;
        int[] pow = new int[nums.length];
        pow[0]=1;
        for (int i = 1; i < nums.length; i++) {
            pow[i]=(pow[i-1]*2)%mod;
        }
        for (int i = 0; i < nums.length; i++) {
            res=(res- (long) (pow[nums.length - 1 - i] - 1) *nums[i]+ (long) (pow[i] - 1) *nums[i])%mod;
        }
        return (int) (res%mod);
    }
//    public int sumSubseqWidths(int[] nums) {
//        int mod=1000000007;
//        Arrays.sort(nums);
//        BigInteger res=new BigInteger(String.valueOf(0));
//        for (int i = 0; i < nums.length; i++) {
//            res =res.add((new BigInteger(String.valueOf(2)).pow(i).subtract(new BigInteger(String.valueOf(2)).pow(nums.length - 1 - i))).multiply(new BigInteger(String.valueOf(nums[i]))));
//        }
//        return res.mod(BigInteger.valueOf(1000000007)).intValue();
//    }
    @Test
    public void test1(){
        int[] nums={2,1,3};
        System.out.println(sumSubseqWidths(nums));
    }
    @Test
    public void test2(){
        int[] nums={2};
        System.out.println(sumSubseqWidths(nums));
    }
    @Test
    public void test3(){
        int[] nums={2,1};
        System.out.println(sumSubseqWidths(nums));
    }
    @Test
    public void test4(){
        int[] nums={3,7,2,3};
        System.out.println(sumSubseqWidths(nums));
    }
    @Test
    public void test5(){
        int[] nums={96,87,191,197,40,101,108,35,169,50,168,182,95,80,144,43,18,60,174,13,77,173,38,46,80,117,13,19,11,6,13,118,39,80,171,36,86,156,165,190,53,49,160,192,57,42,97,35,124,200,84,70,145,180,54,141,159,42,66,66,25,95,24,136,140,159,71,131,5,140,115,76,151,137,63,47,69,164,60,172,153,183,6,70,40,168,133,45,116,188,20,52,70,156,44,27,124,59,42,172};
        System.out.println(sumSubseqWidths(nums));
    }
}
