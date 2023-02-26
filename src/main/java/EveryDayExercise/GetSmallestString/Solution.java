package EveryDayExercise.GetSmallestString;

import org.junit.Test;

public class Solution {
    public String getSmallestString(int n, int k) {
        if(n==0){
            if(k==0){
                return "";
            }else{
                return null;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char c= (char) ('a'+i);
            String s = getSmallestString(n - 1, k - i - 1);
            if(s!=null){
                stringBuilder.append(c);
                stringBuilder.append(s);
                return stringBuilder.toString();
            }
        }
        return null;
    }


    @Test
    public void test1(){
        Solution2 solution2 = new Solution2();
        int n=3;
        int k=27;
        System.out.println(getSmallestString(n,k));
        System.out.println(solution2.getSmallestString(n,k));
    }

    @Test
    public void test2(){
        Solution2 solution2 = new Solution2();
        int n=5;
        int k=73;
        System.out.println(getSmallestString(n,k));
        System.out.println(solution2.getSmallestString(n,k));
    }
}
class Solution2{
    public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        //先创建一个长度为n，全是a的字符串
        for (int i = 0; i < n; i++) {
            stringBuilder.append('a');
        }
        k=k-n;
        //从后往前开始修改，当k>=25时，直接换成z，否则换成对应刚好可以使k为0的字符
        for (int i = stringBuilder.length()-1; i >= 0; i--) {
            if(k>=25){
                stringBuilder.replace(i,i+1,"z");
                k=k-25;
            }else{
                char c= (char) (k+'a');
                stringBuilder.replace(i,i+1,c+"");
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }
}