package EveryDayExercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%k!=0){
            return false;
        }else{
            sum=sum/k;
        }
        sort(nums,0,nums.length-1);
        int[] buckets = new int[k];
        return travel(nums,buckets,0,sum);
    }
    public boolean travel(int[] nums,int[] buckets,int index,int sum){
        if(index==nums.length){
            for (int i = 0; i < buckets.length; i++) {
                if(buckets[i]!=sum){
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i]+nums[index]>sum){
                continue;
            }
            if(i>0&&buckets[i]==buckets[i-1]){
                continue;
            }
            buckets[i]+=nums[index];
            if(travel(nums,buckets,index+1,sum)){
                return true;
            }
            buckets[i]-=nums[index];
        }
        return false;
    }
    public int merge(int previous,int[] nums,int[] status,int sum){
        if(previous==sum){
            return sum;
        }
        for (int i = 0; i < nums.length; i++) {
            if(status[i]==1){
                continue;
            }
            status[i]=1;
            if(previous+nums[i]>sum){
                status[i]=0;
                continue;
            }else if(previous+nums[i]==sum){
                return sum;
            }else if(merge(previous+nums[i],nums,status,sum)==sum){
                return sum;
            }
            status[i]=0;
        }
        return previous;
    }
    public void sort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int partition = partition(nums, low, high);
        sort(nums,low,partition-1);
        sort(nums,partition+1,high);
    }
    public int partition(int[] nums,int low,int high){
        int key=nums[high];
        int i=low-1,j=low,temp;
        while(j<high){
            if(nums[j]>key){
                i++;
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            j++;
        }
        nums[high]=nums[i+1];
        nums[i+1]=key;
        return i+1;
    }
    //???????????????????????????
    private boolean backtrack(int[] nums, int start, int[] bucket, int k, int target, boolean[] used) {
        // k ???????????????
        if (k == 0) return true;
        // ??????????????????????????????????????????
        if (bucket[k] == target) {
            // ??????????????????????????????????????????????????????
            return backtrack(nums, 0, bucket, k - 1, target, used);
        }
        // ??? k ?????????????????????????????????????????????????????????
        for (int i = start; i < nums.length; i++) {
            // ??????????????????????????????????????????
            if (used[i]) continue;
            // ?????????????????????????????????????????????
            if (bucket[k] + nums[i] > target) continue;

            // ?????? && ???????????????
            bucket[k] += nums[i];
            used[i] = true;

            // ????????????????????????????????????
            // ???????????????????????????????????????????????????
            // ???????????? i + 1
            if (backtrack(nums, i + 1, bucket, k, target, used)) return true;

            // ?????? && ???????????????
            bucket[k] -= nums[i];
            used[i] = false;
        }
        // ????????????????????????????????????????????????
        return false;
    }
    @Test
    public void test(){
        int[] nums={4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9};
        int k=5;
        System.out.println(canPartitionKSubsets(nums,k));
    }
}
//DFS+??????
class Solution2 {
    private int[] nums;
    private int[] cur;
    private int s;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        for (int v : nums) {
            s += v;
        }
        if (s % k != 0) {
            return false;
        }
        s /= k;
        cur = new int[k];
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(nums.length - 1);
    }

    private boolean dfs(int i) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < cur.length; ++j) {
            if (j > 0 && cur[j] == cur[j - 1]) {
                continue;
            }
            cur[j] += nums[i];
            if (cur[j] <= s && dfs(i - 1)) {
                return true;
            }
            cur[j] -= nums[i];
        }
        return false;
    }
}
class Solution3 {
    private int[] f;
    private int[] nums;
    private int n;
    private int s;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        for (int v : nums) {
            s += v;
        }
        if (s % k != 0) {
            return false;
        }
        s /= k;
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        f = new int[1 << n];
        return dfs(0, 0);
    }

    private boolean dfs(int state, int t) {
        if (state == (1 << n) - 1) {
            return true;
        }
        if (f[state] != 0) {
            return f[state] == 1;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (t + nums[i] > s) {
                break;
            }
            if (dfs(state | 1 << i, (t + nums[i]) % s)) {
                f[state] = 1;
                return true;
            }
        }
        f[state] = -1;
        return false;
    }
}