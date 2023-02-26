package EveryDayExercise.TwoOutOfThree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] arr = new int[101];
        HashSet<Integer> set = new HashSet<>();
        for (int j : nums1) {
            if (!set.contains(j)) {
                arr[j]++;
                set.add(j);
            }
        }
        set.clear();
        for (int j : nums2) {
            if (!set.contains(j)) {
                arr[j]++;
                set.add(j);
            }
        }
        set.clear();
        for (int j : nums3) {
            if (!set.contains(j)) {
                arr[j]++;
                set.add(j);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>1){
                res.add(i);
            }
        }
        return res;
    }
}
