package PracticePackage.LongestPath;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int max=1;
    public int longestPath(int[] parent, String s) {
        List<Integer>[] lists=new List[s.length()];
        for (int i = 0; i < lists.length; i++) {
            lists[i]=new ArrayList<Integer>();
        }
        for (int i = 1; i < parent.length; i++) {
            lists[parent[i]].add(i);
        }
        dfs(lists,0,s);
        return max;
    }

    public int dfs(List<Integer>[] lists,int i,String s){
        int maxSub=0;
        for(Integer integer:lists[i]){
            int dfs = dfs(lists, integer,s);
            if (s.charAt(i)!=s.charAt(integer)){
                max=Math.max(maxSub+dfs+1,max);
                maxSub=Math.max(maxSub,dfs);
            }
        }
        return maxSub+1;
    }

    @Test
    public void test1(){
        int[] parent={-1,0,0,1,1,2};
        String s="abacbe";
        System.out.println(longestPath(parent,s));
    }

    @Test
    public void test2(){
        int[] parent={-1,0,0,0};
        String s="aabc";
        System.out.println(longestPath(parent,s));
    }

    @Test
    public void test3(){
        int[] parent={-1,137,65,60,73,138,81,17,45,163,145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19};
        String s="ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal";
        System.out.println(longestPath(parent,s));
    }

    @Test
    public void test4(){
        int[] parent={-1,0,1};
        String s="aab";
        System.out.println(longestPath(parent,s));
    }
}
