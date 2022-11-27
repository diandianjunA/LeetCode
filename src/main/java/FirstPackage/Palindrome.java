package FirstPackage;

import org.junit.Test;

public class Palindrome {
    //我的解法
    //执行用时：5 ms, 在所有 Java 提交中击败了68.70%的用户
    //内存消耗：40.5 MB, 在所有 Java 提交中击败了93.40%的用户
    //通过测试用例：11510 / 11510
    public boolean isPalindrome(int x) {
        String str=String.valueOf(x);
        int i=0,j=str.length()-1;
        while(i<=j&&str.charAt(i)==str.charAt(j)){
            i++;
            j--;
        }
        if(i>=j){
            return true;
        }else{
            return false;
        }
    }
    //大佬解法
    public boolean isPalindromePro(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
    @Test
    public void test(){
        int x=1221;
        System.out.println(isPalindrome(x));
    }
}
