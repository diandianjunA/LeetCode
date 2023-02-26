package utils;

import org.junit.Test;

public class RegExp {
    @Test
    public void test(){
        String s="[[1,2],[3,5],[2,2]]";
        String replace = s.replace('[', '{');
        String replace1 = replace.replace(']', '}');
        System.out.println(replace1);
    }
}
