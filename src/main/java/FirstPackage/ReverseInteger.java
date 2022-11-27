package FirstPackage;

import org.junit.Test;


public class ReverseInteger {
    //我的解法
    //执行用时：1 ms, 在所有 Java 提交中击败了40.88%的用户
    //内存消耗：39 MB, 在所有 Java 提交中击败了31.20%的用户
    //通过测试用例：1032 / 1032
    public int reverse(int x) {
        int flag=1;
        String s=x+"";
        StringBuilder res=new StringBuilder();
        if(x<0){
            flag=-1;
            s=s.substring(1);
        }
        for (int i = s.length()-1; i>=0 ; i--) {
            res.append(s.charAt(i));
        }
        int result=0;
        try {
            if(flag<0){
                result=-Integer.parseInt(res.toString());
            }else{
                result=Integer.parseInt(res.toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }
    //大佬解法
    public int reversePro(int x){
        int result = 0;
        while(x != 0) {
            int tmp = result; // 保存计算之前的结果
            result = (result * 10) + (x % 10);
            x /= 10;
            // 将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
            if (result / 10 != tmp) return 0;
        }
        return result;
    }
    @Test
    public void test(){
        int x=1534236469;
        System.out.println(reverse(x));
    }
}
