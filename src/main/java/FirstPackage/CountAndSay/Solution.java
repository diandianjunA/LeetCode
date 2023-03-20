package FirstPackage.CountAndSay;

import org.junit.Test;

public class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        if(s.length()==1){
            res.append(1);
            res.append(s);
            return res.toString();
        }
        for (int i = 1; i <= s.length(); i++) {
            int length=1;
            while(i<s.length()&&s.charAt(i)==s.charAt(i-1)){
                length++;
                i++;
            }
            res.append(length);
            res.append(s.charAt(i-1));
        }
        return res.toString();
    }

    @Test
    public void test1(){
        int n=1;
        System.out.println(countAndSay(1));
    }

    @Test
    public void test2(){
        int n=1;
        System.out.println(countAndSay(4));
    }
}
