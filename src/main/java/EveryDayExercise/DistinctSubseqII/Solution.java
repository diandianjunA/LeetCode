package EveryDayExercise.DistinctSubseqII;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
//    public int distinctSubseqII(String s) {
//        ArrayList<HashSet<String>> hashSets = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            hashSets.add(new HashSet<String>());
//        }
//        getDistinctSubsequenceNum(new StringBuilder(s),hashSets);
//        long res=0;
//        for (HashSet<String> hashSet:hashSets) {
//            res+=hashSet.size();
//        }
//        return (int) (res%(Math.pow(10,9)+7));
//    }
//    public void getDistinctSubsequenceNum(StringBuilder s,ArrayList<HashSet<String>> hashSets){
//        if(s.length()==1){
//            hashSets.get(0).add(s.toString());
//            return;
//        }else{
//            hashSets.get(s.length()-1).add(s.toString());
//            for (int i = 0; i < s.length(); i++) {
//                getDistinctSubsequenceNum(new StringBuilder(s).replace(i,i+1,""),hashSets);
//            }
//        }
//    }
public int distinctSubseqII(String s) {
    long[] dp = new long[s.length()];
    dp[0]=1;
    long[] map = new long[26];
    map[s.charAt(0)-97]=1;
    for (int i = 1; i < s.length(); i++) {
        dp[i]= (2*dp[i-1]+1-map[s.charAt(i)-97])%1000000007;
        if(dp[i]<0){
            dp[i]+=1000000007;
        }
        map[s.charAt(i)-97]= (dp[i-1]+1);
    }
    return (int) (dp[dp.length-1]%1000000007);
}
    @Test
    public void test1(){
        String s="abc";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test2(){
        String s="aba";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test3(){
        String s="aaa";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test4(){
        String s="wlkwybehph";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test5(){
        String s="xchdhiebcu";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test6(){
        String s="lee";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test7(){
        String s="cfffe";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test8(){
        String s="zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(distinctSubseqII(s));
    }

    @Test
    public void test9(){
        String s="blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr";
        System.out.println(distinctSubseqII(s));
    }
}
class Solution2 {
    public int distinctSubseqII(String s) {
        long[] dp = new long[s.length()];
        ArrayList<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        dp[0]=1;
        long[] map = new long[26];
        map[s.charAt(0)-97]++;
        for (int i = 0; i < s.length(); i++) {
            dp[i]=2*dp[i-1]+1-map[s.charAt(i)-97];
            map[s.charAt(i)-97]=dp[i];
        }
        return (int) (dp[dp.length-1]%(Math.pow(10,9)+7));
    }
}