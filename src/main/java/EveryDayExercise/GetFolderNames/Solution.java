package EveryDayExercise.GetFolderNames;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if(map.containsKey(names[i])){
                int j=map.get(names[i]);
                StringBuilder stringBuilder = new StringBuilder(names[i]);
                stringBuilder.append("(");
                stringBuilder.append(j++);
                stringBuilder.append(")");
                while (map.containsKey(stringBuilder.toString())){
                    stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
                    stringBuilder.append(j++);
                    stringBuilder.append(")");
                }
                res.add(stringBuilder.toString());
                map.put(names[i],j);
                map.put(stringBuilder.toString(),1);
            }else{
                res.add(names[i]);
                map.put(names[i],1);
            }
        }
        return res.toArray(new String[0]);
    }

    @Test
    public void test1(){
        String[] names={"pes","fifa","gta","pes(2019)"};
        String[] res=getFolderNames(names);
        for (String re : res) {
            System.out.println(re);
        }
    }

    @Test
    public void test2(){
        String[] names={"gta","gta(1)","gta","avalon"};
        String[] res=getFolderNames(names);
        for (String re : res) {
            System.out.println(re);
        }
    }

    @Test
    public void test3(){
        String[] names={"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        String[] res=getFolderNames(names);
        for (String re : res) {
            System.out.println(re);
        }
    }

    @Test
    public void test4(){
        String[] names={"wano","wano","wano","wano"};
        String[] res=getFolderNames(names);
        for (String re : res) {
            System.out.println(re);
        }
    }

    @Test
    public void test5(){
        String[] names={"kaido","kaido(1)","kaido","kaido(1)"};
        String[] res=getFolderNames(names);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
