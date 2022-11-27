package IsFlipedString;

import org.junit.Test;

public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        s2=s2+s2;
        int j=0;
        for (int i = 0; i < s2.length()&&j<s1.length(); i++) {
            if(s2.charAt(i)==s1.charAt(j)){
                while(j<s1.length()&&i<s2.length()){
                    if(s1.charAt(j)==s2.charAt(i)){
                        j++;
                        i++;
                    }else {
                        j=0;
                        break;
                    }
                }
            }
        }
        if(j==s1.length()){
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void test(){
        String s1="aba";
        String s2="bab";
        System.out.println(isFlipedString(s1,s2));
    }
}
class Solution2 {
    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt((i + j) % n) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
class Solution3 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}