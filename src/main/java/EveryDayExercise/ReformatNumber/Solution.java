package EveryDayExercise.ReformatNumber;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public String reformatNumber(String number) {
        ArrayList<Character> characters = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i)>='0'&&number.charAt(i)<='9'){
                characters.add(number.charAt(i));
            }
        }
        int index = characters.size() / 3;
        if(characters.size()-index*3==0){
            for (int i = 0; i < index; i++) {
                res.append(characters.get(3*i));
                res.append(characters.get(3*i+1));
                res.append(characters.get(3*i+2));
                if(i!=index-1){
                    res.append('-');
                }
            }
        } else if (characters.size() - index*3 == 1) {
            index--;
            for (int i = 0; i < index; i++) {
                res.append(characters.get(3*i));
                res.append(characters.get(3*i+1));
                res.append(characters.get(3*i+2));
                res.append('-');
            }
            res.append(characters.get(characters.size()-4));
            res.append(characters.get(characters.size()-3));
            res.append('-');
            res.append(characters.get(characters.size()-2));
            res.append(characters.get(characters.size()-1));
        }else{
            for (int i = 0; i < index; i++) {
                res.append(characters.get(3*i));
                res.append(characters.get(3*i+1));
                res.append(characters.get(3*i+2));
                res.append('-');
            }
            res.append(characters.get(characters.size()-2));
            res.append(characters.get(characters.size()-1));
        }
        return res.toString();
    }
    @Test
    public void test(){
        String number="123 4-5678";
        System.out.println(reformatNumber(number));
    }
}
