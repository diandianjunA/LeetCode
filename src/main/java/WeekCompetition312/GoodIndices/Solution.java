package WeekCompetition312.GoodIndices;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums.length<2*k+1){
            return res;
        }
        int l=0;
        int r=2*k;
        boolean preCorrect=false;
        boolean isCorrect = true;
        while(r<nums.length){
            if(preCorrect&&k>=2){
                if(nums[l+k-1]<=nums[l+k-2]&&nums[r]>=nums[r-1]){
                    isCorrect=true;
                }else{
                    isCorrect=false;
                }
            }else{
                for (int i = l; i <l+k-1; i++) {
                    if(nums[i+1]>nums[i]){
                        isCorrect=false;
                        break;
                    }
                }
                if(isCorrect){
                    for (int i = l+k+1; i < r; i++) {
                        if(nums[i+1]<nums[i]){
                            isCorrect=false;
                            break;
                        }
                    }
                }
            }
            if(isCorrect){
                res.add(l+k);
            }
            l++;
            r++;
            preCorrect=isCorrect;
            isCorrect=true;
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums={478184,863008,716977,921182,182844,350527,541165,881224};
        int k=1;
        System.out.println(goodIndices(nums,k));
    }
}
