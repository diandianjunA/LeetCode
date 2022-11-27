package DataStructureLearningPlan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            temp.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if(temp.contains(nums1[i])){
                res.add(nums1[i]);
                temp.remove(temp.indexOf(nums1[i]));
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=res.get(i);
        }
        return result;
    }
    @Test
    public void test(){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
}
