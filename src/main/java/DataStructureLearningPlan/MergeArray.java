package DataStructureLearningPlan;

public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[m + 1];
        int[] b = new int[n + 1];
        for (int i = 0; i < m; i++) {
            a[i]=nums1[i];
        }
        for (int i = 0; i < n; i++) {
            b[i]=nums2[i];
        }
        a[m]=Integer.MAX_VALUE;
        b[n]=Integer.MAX_VALUE;
        int i1=0,i2=0;
        for (int i = 0; i < m + n; i++) {
            if(a[i1]<b[i2]){
                nums1[i]=a[i1];
                i1++;
            }else{
                nums1[i]=b[i2];
                i2++;
            }
        }
    }
}
