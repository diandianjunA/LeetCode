package EveryDayExercise.AreSentencesSimilar;

import java.util.Objects;

public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(s2.length>s1.length){
            String[] temp=s1;
            s1=s2;
            s2=temp;
        }
        int i=0;
        int j=s2.length-1;
        int k=s1.length-1;
        while(i<=j){
            if(Objects.equals(s1[i], s2[i])){
                i++;
            }else{
                break;
            }
        }
        while(i<=j){
            if(Objects.equals(s1[k],s2[j])){
                k--;
                j--;
            }else{
                break;
            }
        }
        return i > j;
    }
}
