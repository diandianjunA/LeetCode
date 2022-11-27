package FirstPackage;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
//
//算法的时间复杂度应该为 O(log (m+n)) 。
//
public class FindMedianSortedArrays {
    //我的解法
    //执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
    //内存消耗：42.3 MB, 在所有 Java 提交中击败了55.74%的用户
    //通过测试用例：2094 / 2094
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int[] arr1 = new int[nums1.length + 1];
        int[] arr2 = new int[nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            arr1[i]=nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            arr2[i]=nums2[i];
        }
        arr1[arr1.length-1]=Integer.MAX_VALUE;
        arr2[arr2.length-1]=Integer.MAX_VALUE;
        int i=0,j=0,k=0;
        while(i<result.length){
            if(arr1[j]>arr2[k]){
                result[i++]=arr2[k++];
            }else{
                result[i++]=arr1[j++];
            }
        }
        if(result.length%2==0){
            return ((double)(result[(result.length-1)/2]+result[(result.length/2)]))/2;
        }else{
            return result[result.length/2];
        }
    }
}
