package EveryDayExercise;

import org.junit.Test;

import java.util.ArrayList;

public class test {
    @Test
    public void test1(){
        ArrayList<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('b');
        characters.add('c');
        ArrayList<Character> characters1 = new ArrayList<>();
        characters1.add('a');
        characters1.add('a');
        characters1.add('c');
        System.out.println(characters.containsAll(characters1));
    }
}
