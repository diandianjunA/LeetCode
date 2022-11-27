package EveryDayExercise.MagicalString;

import org.junit.Test;

public class Solution {
    public int magicalString(int n) {
        StringBuilder str = new StringBuilder();
        str.append("122");
        int i=2;
        char index='1';
        int res=1;
        while(str.length()<n){
            if(str.charAt(i)=='1'){
                res++;
            }else{
                str.append(index);
            }
            str.append(index);
            index=(index=='1'?'2':'1');
            i++;
        }
        for (; i < n; i++) {
            if(str.charAt(i)=='1'){
                res++;
            }
        }
        return res;
    }
    @Test
    public void test1(){
        System.out.println(magicalString(6));
    }
    @Test
    public void test2(){
        System.out.println(magicalString(1));
    }
    @Test
    public void test3(){
        System.out.println(magicalString(5));
    }
}
class Solution2 {
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    ++res;
                }
                ++j;
                --size;
            }
            ++i;
        }
        return res;
    }
}