package FirstPackage.StrStr;

import org.junit.Test;

public class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int i=0;
        int j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==needle.length()){
            return i-j;
        }else{
            return -1;
        }
    }

    public int[] getNext(String subStr){
        int[] next = new int[subStr.length()];
        next[0]=-1;
        if(next.length==1){
            return next;
        }
        next[1]=0;
        int i=2;
        int j=0;
        while(i<subStr.length()){
            if(j==-1||subStr.charAt(i-1)==subStr.charAt(j)){
                next[i]=j+1;
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        return next;
    }

    @Test
    public void test1(){
        String hayStack="sadbutsad";
        String needle="sad";
        System.out.println(strStr(hayStack,needle));
    }

    @Test
    public void test2(){
        String hayStack="leetcode";
        String needle="leeto";
        System.out.println(strStr(hayStack,needle));
    }

    @Test
    public void test3(){
        String hayStack="a";
        String needle="a";
        System.out.println(strStr(hayStack,needle));
    }

    @Test
    public void test4(){
        String hayStack="aabaaabaaac";
        String needle="aabaaac";
        System.out.println(strStr(hayStack,needle));
    }
}
