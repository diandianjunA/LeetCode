package EveryDayExercise.FindLongestSubarray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] findLongestSubarray(String[] array) {
        int[] map = new int[array.length + 1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('A'+i)+"");
            list.add((char)('a'+i)+"");
        }
        map[0]=0;
        for (int i = 0; i < array.length; i++) {
            if(list.contains(array[i])){
                map[i+1]=map[i]+1;
            }else{
                map[i+1]=map[i];
            }
            hashMap.put(2*map[i+1]-i-1,i+1);
        }
        int res=0;
        int from=0;
        for (int i = 0; i < array.length&&(array.length-i)>res; i++) {
            if(hashMap.containsKey(2*map[i]-i)){
                Integer j = hashMap.get(2 * map[i] - i);
                if(j-i>res){
                    res=j-i;
                    from=i;
                }else if(j-i==res&&from>i){
                    from=i;
                }
            }
        }
        String[] r = new String[res];
        for (int i = from; i < from+res; i++) {
            r[i-from]=array[i];
        }
        return r;
    }

    @Test
    public void test1(){
        String[] array={"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        System.out.println(Arrays.toString(findLongestSubarray(array)));
    }

    @Test
    public void test2(){
        String[] array={"A","A"};
        System.out.println(Arrays.toString(findLongestSubarray(array)));
    }

    @Test
    public void test3(){
        String[] array={"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        System.out.println(Arrays.toString(findLongestSubarray(array)));
    }
}
