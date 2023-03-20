package utils;

import org.junit.Test;

public class RegExp {
    @Test
    public void test(){
        String s="[[24,11,22,17,4],[21,16,5,12,9],[6,23,10,3,18],[15,20,1,8,13],[0,7,14,19,2]]";
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

    @Test
    public void test3(){
        String s="[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n";
        String replace = s.replace('[', '{');
        String replace1 = replace.replace(']', '}');
        String replace2 = replace1.replace("\"", "'");
        System.out.println(replace2);
    }
}
