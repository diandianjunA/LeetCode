package WeekCompetition312.SortPeople;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for (int i=heights.length-1;i>=0;i--){
            names[heights.length-1-i]=map.get(heights[i]);
        }
        return names;
    }
    @Test
    public void test(){
        String[] name = {"Mary","John","Emma"};
        int[] heights={180,165,170};
        System.out.println(Arrays.toString(sortPeople(name,heights)));
    }
}
