package FirstPackage.CheckPalindromeFormation;

import org.junit.Test;

public class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int i = 0;
        int j=b.length()-1;
        while(i<j){
            if (a.charAt(i)==b.charAt(j)){
                i++;
                j--;
            }else{
                break;
            }
        }
        if(i>=j){
            return true;
        }else{
            int preI=i;
            int preJ=j;
            while(i<j){
                if (b.charAt(i)==b.charAt(j)){
                    i++;
                    j--;
                }else{
                    break;
                }
            }
            if(i>=j){
                return true;
            }
            i=preI;
            j=preJ;
            while(i<j){
                if (a.charAt(i)==a.charAt(j)){
                    i++;
                    j--;
                }else{
                    break;
                }
            }
            if(i>=j){
                return true;
            }
        }
        i=a.length()-1;
        j=0;
        while(j<i){
            if (a.charAt(i)==b.charAt(j)){
                i--;
                j++;
            }else{
                break;
            }
        }
        if(j>=i){
            return true;
        }else{
            int preI=i;
            int preJ=j;
            while(j<i){
                if (a.charAt(j)==a.charAt(i)){
                    j++;
                    i--;
                }else{
                    break;
                }
            }
            if(j>=i){
                return true;
            }
            i=preI;
            j=preJ;
            while(j<i){
                if (b.charAt(j)==b.charAt(i)){
                    j++;
                    i--;
                }else{
                    break;
                }
            }
            if(j>=i){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        String a="x";
        String b="y";
        System.out.println(checkPalindromeFormation(a,b));
    }

    @Test
    public void test2(){
        String a="abdef";
        String b="fecab";
        System.out.println(checkPalindromeFormation(a,b));
    }

    @Test
    public void test3(){
        String a="ulacfd";
        String b="jizalu";
        System.out.println(checkPalindromeFormation(a,b));
    }

    @Test
    public void test4(){
        String a="pvhmupgqeltozftlmfjjde";
        String b= "yjgpzbezspnnpszebzmhvp";
        System.out.println(checkPalindromeFormation(a,b));
    }

    @Test
    public void test5(){
        String a="aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd";
        String b="uvebspqckawkhbrtlqwblfwzfptanhiglaabjea";
        System.out.println(checkPalindromeFormation(a,b));
    }
}
