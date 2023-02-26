package EveryDayExercise.BalancedString;


public class Solution {
    public int balancedString(String s) {
        int[] count = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'A']++;
        }

        int left = 0, right = 0;
        int res = len;
        int average = len / 4;

        while (right < len) {
            //滑动窗口里进来一个元素 就把count里的这个值减1
            count[s.charAt(right) - 'A']--;
            //如果四个元素都符合要求 就计算最小值
            while (left < len && count['Q' - 'A'] <= average && count['W' - 'A'] <= average && count['E' - 'A'] <= average && count['R' - 'A'] <= average) {
                res = Math.min(res, right - left + 1);
                //移动左指针 看能不能缩小范围
                count[s.charAt(left) - 'A']++;
                left++;
            }
            right++;
        }
        return res;
    }
}
