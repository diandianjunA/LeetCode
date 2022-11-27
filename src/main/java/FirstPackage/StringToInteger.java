package FirstPackage;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringToInteger {
    //我的解法
    //执行用时：2 ms, 在所有 Java 提交中击败了28.07%的用户
    //内存消耗：41.1 MB, 在所有 Java 提交中击败了85.88%的用户
    //通过测试用例：1082 / 1082
    public int myAtoi(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int index=0;
        int flag=1;
        while(index<s.length()&&s.charAt(index)==' '){
            index++;
        }
        if(index>=s.length()){
            return 0;
        }
        if(s.charAt(index)=='+'){
            flag=1;
            index++;
        }else if(s.charAt(index)=='-'){
            flag=-1;
            index++;
        }else if(s.charAt(index)<'0'||s.charAt(index)>'9'){
            return 0;
        }
        while(index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            stringBuilder.append(s.charAt(index));
            index++;
        }
        if(stringBuilder.length()==0){
            return 0;
        }
        int result=0;
        if(flag>0){
            try {
                result=Integer.parseInt(stringBuilder.toString());
            } catch (NumberFormatException e) {
                return Integer.MAX_VALUE;
            }
        }else{
            try {
                result=-Integer.parseInt(stringBuilder.toString());
            } catch (NumberFormatException e) {
                return Integer.MIN_VALUE;
            }
        }
        return result;
    }
    //大佬解法
    //自动机，为程序每个阶段设定一个状态，某个阶段检测到某种字符后进入对应状态
    public int myAtoiPro(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    @Test
    public void test(){
        String s="+-12";
        System.out.println(myAtoi(s));
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}