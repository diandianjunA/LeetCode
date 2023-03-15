package utils;

import org.junit.Test;

public class RegExp {
    @Test
    public void test(){
        String s="[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]";
        String replace = s.replace('[', '{');
        String replace1 = replace.replace(']', '}');
        System.out.println(replace1);
    }

    @Test
    public void test1(){
        String s="{a,b}{c,d{e,f},g}";
        for (String s1 : s.split("}")) {
            System.out.println(s1);
        }

    }
}
