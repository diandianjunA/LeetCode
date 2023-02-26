package FirstPackage.GenerateParenthesis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if(n==0){
            return list;
        } else if (n == 1) {
            list.add("()");
        } else {
            for (String generateParenthesis : generateParenthesis(n-1)) {
                if(!list.contains("("+generateParenthesis+")")){
                    list.add("("+generateParenthesis+")");
                }
                if(!list.contains("()"+generateParenthesis)){
                    list.add("()"+generateParenthesis);
                }
                if(!list.contains(generateParenthesis+"()")){
                    list.add(generateParenthesis+"()");
                }
            }
            for (int i = 1; i < n-1; i++) {
                List<String> list1 = generateParenthesis(i);
                List<String> list2 = generateParenthesis(n - i - 1);
                for(String s1:list1){
                    for(String s2:list2){
                        if(!list.contains("("+s1+")"+s2)){
                            list.add("("+s1+")"+s2);
                        }
                        if(!list.contains(s2+"("+s1+")")){
                            list.add(s2+"("+s1+")");
                        }
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test1(){
        int n=3;
        System.out.println(generateParenthesis(n));
    }

    @Test
    public void test2(){
        int n=1;
        System.out.println(generateParenthesis(n));
    }

    @Test
    public void test3(){
        int n=4;
        System.out.println(generateParenthesis(n));
    }
}
