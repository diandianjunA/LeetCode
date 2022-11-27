package FirstPackage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
//
//比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//请你实现这个将字符串进行指定行数变换的函数：
//
//string convert(string s, int numRows);

public class ConvertToZ {
    //我的解法
    //执行用时：7 ms, 在所有 Java 提交中击败了52.80%的用户
    //内存消耗：41.8 MB, 在所有 Java 提交中击败了74.62%的用户
    //通过测试用例：1157 / 1157
    public String convert(String s, int numRows) {
        Queue[] queues = new Queue[numRows];
        for (int i = 0; i < numRows; i++) {
            queues[i]=new LinkedList();
        }
        int index=0;
        int i=-2;
        StringBuilder res = new StringBuilder();
        if(numRows>1){
            while(index<s.length()){
                for (i=i+2;i<numRows&&index<s.length();i++){
                    queues[i].add(s.charAt(index++));
                }
                if(i==numRows){
                    for (i=i-2;i>=0&&index<s.length();i--){
                        queues[i].add(s.charAt(index++));
                    }
                }
            }
            for (i=0;i<numRows;i++){
                while(!queues[i].isEmpty()){
                    res=res.append(queues[i].remove());
                }
            }
        }else{
            res.append(s);
        }
        return res.toString();
    }
    //大佬解法
    public String convertPro(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
    @Test
    public void answerTest(){
        String s="AB";
        System.out.println(convert(s,1));
    }
}
