package EveryDayExercise.NumDifferentIntegers;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;

public class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<BigInteger> hashSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if((word.charAt(i)>='a'&&word.charAt(i)<='z')||(word.charAt(i)>='A'&&word.charAt(i)<='Z')){
                continue;
            }
            int p=i;
            while(i<word.length()&&word.charAt(i)>='0'&&word.charAt(i)<='9'){
                i++;
            }
            BigInteger res = new BigInteger(word.substring(p,i));
            hashSet.add(res);
        }
        return hashSet.size();
    }
    @Test
    public void test1(){
        String word="035985750011523523129774573439111590559325a1554234973";
        System.out.println(numDifferentIntegers(word));
    }
}
