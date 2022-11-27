package FirstPackage;

import org.junit.Test;

//给你一个字符串 s，找到 s 中最长的回文子串。
public class LongestPalindrome {
    //我的解法
    //执行用时：1934 ms, 在所有 Java 提交中击败了/5.02%的用户
    //内存消耗：40.9 MB, 在所有 Java 提交中击败了99.16%的用户
    //通过测试用例：140 / 140
    public String longestPalindrome(String s) {
        int i=0,j=s.length()-1;
        int max=1;
        int temp;
        String maxString = s.substring(0,1);
        for (i=0;i<s.length();i++){
            while(j>i){
                if(s.charAt(j)!=s.charAt(i)){
                    j--;
                }else{
                    int k=i;
                    temp=j-1;
                    while(k<j&&s.charAt(k)==s.charAt(j)){
                        k++;
                        j--;
                    }
                    if(k==j){
                        if(max<2*(k-i)+1){
                            max=2*(k-i)+1;
                            maxString=s.substring(i,2*k-i+1);
                        }
                    }else if(s.charAt(k)==s.charAt(j)){
                        if(max<2*(j-i+1)){
                            max=2*(j-i+1);
                            maxString=s.substring(i,2*j-i+1+1);
                        }
                    }
                    j=temp;
                }
            }
            j=s.length()-1;
        }
        return maxString;
    }
    @Test
    public void test(){
        String s="babad";
        System.out.println(longestPalindrome(s));
    }
}
