package DataStructureLearningPlan.Pascal2;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public BigInteger[] nums=new BigInteger[33];
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(couple(rowIndex,i).intValue());
        }
        return res;
    }
    public BigInteger couple(int n,int m){
        return getFactorial(n).divide((getFactorial(m).multiply(getFactorial(n-m))));
    }
    public BigInteger getFactorial(int n){
        if(nums[n]!=null){
            return nums[n];
        }
        return nums[n]=factorial(n);
    }
    public BigInteger factorial(int n){
        BigInteger sum= BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            sum=sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }
    @Test
    public void test(){
        for (Integer integer : getRow(21)) {
            System.out.println(integer);
        }

    }
}
class Solution2{
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            list.add((int) ((long)list.get(i)*(rowIndex-i)/(i+1)));
        }
        return list;
    }
}