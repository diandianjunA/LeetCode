package EveryDayExercise.AreAlmostEqual;

import org.junit.Test;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int index=-1;
        boolean hasChanged=false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)== s2.charAt(i)){
            }else{
                if(!hasChanged){
                    if(index==-1){
                        index=i;
                    }else{
                        if(s1.charAt(index)==s2.charAt(i)&&s1.charAt(i)==s2.charAt(index)){
                            hasChanged=true;
                            index=-1;
                        }else {
                            return false;
                        }
                    }
                }else{
                    return false;
                }
            }
        }
        return index == -1;
    }
    @Test
    public void test(){
        String s1="bank";
        String s2="kanb";
        System.out.println(areAlmostEqual(s1,s2));
    }
    @Test
    public void test2(){
        String s1="attack";
        String s2="defend";
        System.out.println(areAlmostEqual(s1,s2));
    }
    @Test
    public void test3(){
        String s1="kelb";
        String s2="kelb";
        System.out.println(areAlmostEqual(s1,s2));
    }
    @Test
    public void test4(){
        String s1="abcd";
        String s2="dcba";
        System.out.println(areAlmostEqual(s1,s2));
    }
    @Test
    public void test5(){
        String s1="aa";
        String s2="ac";
        System.out.println(areAlmostEqual(s1,s2));
    }
}
