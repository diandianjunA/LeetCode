package DataStructureLearningPlan.SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        for (int i = nums.length/2-1; i >= 0; i--) {
            adjust(nums,i,nums.length);
        }
        for (int i = nums.length-1; i > 0; i--) {
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            adjust(nums,0,i);
        }
    }
    public void adjust(int[] nums,int index,int length){
        int temp=nums[index];
        for (int i = 2*index+1; i < length; i=2*i+1) {
            if(i+1<length&&nums[i]<nums[i+1]){
                i++;
            }
            if(nums[i]>temp){
                nums[index]=nums[i];
                index=i;
            }else {
                break;
            }
        }
        nums[index]=temp;
    }
}
class Solution2 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}
class Solution3 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}
class Solution4 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}