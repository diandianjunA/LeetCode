package EveryDayExercise.RemoveSubfolders;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < folder.length; ) {
            res.add(folder[i]);
            int j=i+1;
            while(j< folder.length){
                if(folder[j].length()<=folder[i].length()){
                    break;
                }else {
                    if(folder[i].equals(folder[j].substring(0,folder[i].length()))&&folder[j].charAt(folder[i].length())=='/'){
                        j++;
                    }else {
                        break;
                    }
                }
            }
            i=j;
        }
        return res;
    }

    @Test
    public void test1(){
        String[] folder={"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(removeSubfolders(folder));
    }

    @Test
    public void test2(){
        String[] folder={"/a","/a/b/c","/a/b/d"};
        System.out.println(removeSubfolders(folder));
    }

    @Test
    public void test3(){
        String[] folder={"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(removeSubfolders(folder));
    }
}
