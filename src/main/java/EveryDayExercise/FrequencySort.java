package EveryDayExercise;

import org.junit.Test;

import java.util.*;

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(frequencyMap.containsKey(nums[i])){
                frequencyMap.put(nums[i],frequencyMap.get(nums[i])+1);
            }else{
                frequencyMap.put(nums[i],1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue()>o2.getValue()){
                    return 1;
                }else if(o1.getValue()== o2.getValue()){
                    if(o1.getKey()>o2.getKey()){
                        return -1;
                    }else if(o1.getKey()==o2.getKey()){
                        return 0;
                    }else{
                        return 1;
                    }
                }else{
                    return -1;
                }
            }
        });
        int i=0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int j = 0; j < entry.getValue(); j++) {
                nums[i++]=entry.getKey();
            }
        }
        return nums;
    }
    @Test
    public void test(){
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
