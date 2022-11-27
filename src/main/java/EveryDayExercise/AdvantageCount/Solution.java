package EveryDayExercise.AdvantageCount;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> nums2Map = new TreeMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(i,nums2[i]);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(nums2Map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()- o2.getValue();
            }
        });
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]>list.get(0).getValue()){
                map.put(list.get(0).getKey(),nums1[i]);
                list.remove(0);
            }else{
                map.put(list.get(list.size()-1).getKey(),nums1[i]);
                list.remove(list.size()-1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            nums1[entry.getKey()]=entry.getValue();
        }
        return nums1;
    }
    @Test
    public void test(){
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {1,10,4,11};
        int[] res = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    @Test
    public void test2(){
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        int[] res = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
//    @Test
//    public void test3(){
//        Pair<Integer, Integer> pair1 = new Pair<>();
//        Pair<Integer, Integer> pair2 = new Pair<>();
//        Pair<Integer, Integer> pair3 = new Pair<>();
//        Pair<Integer, Integer> pair4 = new Pair<>();
//        pair1.first=1;
//        pair1.second=2;
//        pair2.first=3;
//        pair2.second=4;
//        pair3.first=2;
//        pair3.second=5;
//        pair4.first=10;
//        pair4.second=1;
//        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
//        pairs.add(pair1);
//        pairs.add(pair4);
//        pairs.add(pair2);
//        pairs.add(pair3);
//        for (Pair<Integer,Integer> pair:pairs){
//            System.out.println(pair);
//        }
//        Collections.sort(pairs);
//        System.out.println("=======================");
//        for (Pair<Integer,Integer> pair:pairs){
//            System.out.println(pair);
//        }
//    }
    @Test
    public void test4(){
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {1,10,4,11};
        Solution4 solution4 = new Solution4();
        int[] res = solution4.advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
class Solution2 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }
}
class Solution3{
    public int[] advantageCount2(int[] nums1, int[] nums2) {
        //minIndex 是最小元素的索引
        int n = nums1.length, minIndex = 0;
        //判断num1的元素 是否使用
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        //排序
        Arrays.sort(nums1);
        for (int i = 0; i < n; i++) {
            int left = 0, right = n;
            //二分查找 找最小的大于 num2[i]的元素
            while (left != right) {
                int mid = left + ((right - left) >> 1);
                if (nums1[mid] < nums2[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            //是否访问 或者 相同
            while (left < n && (visited[left] || nums1[left] == nums2[i])) {
                left++;
            }
            if (left == n) {
                //没有大于num[i]的元素，取最小的元素
                while (visited[minIndex]) {
                    minIndex++;
                }
                ans[i] = nums1[minIndex];
                visited[minIndex++] = true;
            } else {
                visited[left] = true;
                ans[i] = nums1[left];
            }
        }
        return ans;
    }
}
//class Pair<ElementType1,ElementType2> implements Comparable<Pair<ElementType1,ElementType2>>{
//
//    ElementType1 first;
//    ElementType2 second;
//
//    @Override
//    public int compareTo(Pair<ElementType1, ElementType2> o) {
//        try {
//            Method elementType1CompareTo = first.getClass().getDeclaredMethod("compareTo", first.getClass());
//            int res1 = (int)elementType1CompareTo.invoke(first, o.first);
//            if(res1>0){
//                return 1;
//            } else if (res1 < 0) {
//                return -1;
//            }else{
//                Method elementType2CompareTo = second.getClass().getDeclaredMethod("compareTo", second.getClass());
//                int res2 = (int)elementType2CompareTo.invoke(second, o.second);
//                return res2;
//            }
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Pair{" +
//                "first=" + first +
//                ", second=" + second +
//                '}';
//    }
//}
class Solution4{
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans;
        ans = new int[nums2.length];
        ArrayList<pair<Integer,Integer>> al=new ArrayList<pair<Integer,Integer>>();
        // al.setSize(nums2.length);
        for(int i=0;i<nums2.length;i++)
        {
            al.add(new pair<Integer,Integer>(nums2[i],i));
            // al.elementAt(i).put(i, nums2[i]);//put(i,nums2[i]);
        }
        // ArrayList<Map.Entry<Integer,Integer>> al = new ArrayList<>(mp.entrySet());
        Arrays.sort(nums1);
        // Collections.sort(al,new Comparator<Map.Entry<Integer,Integer>>(){
        //     public int compare(Map.Entry<Integer,Integer> a1,Map.Entry<Integer,Integer> a2) {
        //         return a1.getValue()-a2.getValue();
        //     }
        // });
        Collections.sort(al);
        int l=0,r=nums2.length-1;
        for(int i=0;i<nums2.length;i++)
        {
            if(nums1[i]>al.get(l).getFirst())
            {
                ans[al.get(l).getSecond()]=nums1[i];
                l++;
            }else
            {
                ans[al.get(r).getSecond()]=nums1[i];
                r--;
            }
        }
        return ans;
    }
}
class pair<ElementType1,ElementType2> implements Comparable<pair<ElementType1,ElementType2>>{

    private ElementType1 first;
    private ElementType2 second;

    public void setF(ElementType1 first)
    {
        this.first=first;
    }

    public void setS(ElementType2 second)
    {
        this.second=second;
    }

    public void put(ElementType1 first,ElementType2 second)
    {
        this.first=first; this.second=second;
    }

    public pair(ElementType1 first,ElementType2 second)
    {
        this.first=first; this.second=second;
    }

    public ElementType1 getFirst()
    {
        return this.first;
    }

    public ElementType2 getSecond()
    {
        return this.second;
    }

    public int compareTo(pair<ElementType1, ElementType2> o)
    {
        try
        {
            Method T1=first.getClass().getDeclaredMethod("compareTo", first.getClass());
            T1.setAccessible(true);
            int res1=(int)T1.invoke(first, o.first);
            if(res1!=0)
                return res1;
            Method T2=second.getClass().getDeclaredMethod("compareTo", second.getClass());
            T2.setAccessible(true);
            int res2=(int)T2.invoke(second, o.second);
            return res2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}