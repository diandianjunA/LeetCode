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
    //方法二：以桶的视角
    private boolean backtrack(int[] nums, int start, int[] bucket, int k, int target, boolean[] used) {
        // k 个桶均装满
        if (k == 0) return true;
        // 当前桶装满了，开始装下一个桶
        if (bucket[k] == target) {
            // 注意：桶从下一个开始；球从第一个开始
            return backtrack(nums, 0, bucket, k - 1, target, used);
        }
        // 第 k 个桶开始对每一个球选择进行选择是否装入
        for (int i = start; i < nums.length; i++) {
            // 如果当前球已经被装入，则跳过
            if (used[i]) continue;
            // 如果装入当前球，桶溢出，则跳过
            if (bucket[k] + nums[i] > target) continue;

            // 装入 && 标记已使用
            bucket[k] += nums[i];
            used[i] = true;

            // 开始判断是否选择下一个球
            // 注意：桶依旧是当前桶；球是下一个球
            // 注意：是 i + 1
            if (backtrack(nums, i + 1, bucket, k, target, used)) return true;

            // 拿出 && 标记未使用
            bucket[k] -= nums[i];
            used[i] = false;
        }
        // 如果所有球均不能使所有桶刚好装满
        return false;
    }
    @Test
    public void test(){
        int[] nums={4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9};
        int k=5;
        System.out.println(canPartitionKSubsets(nums,k));
    }
}
//DFS+剪枝
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