package EveryDayExercise.CanTransform;

import org.junit.Test;

public class Solution {
    public boolean canTransform(String start, String end) {
        int i=0,j=0;
        char[] starts = start.toCharArray();
        char[] ends = end.toCharArray();
        while (i<start.length()){
            if (starts[i]==ends[i]){
                i++;
            }else {
                j=i+1;
                while (j<start.length()&&starts[j]!=ends[i]){
                    j++;
                }
                if(j>=starts.length){
                    return false;
                }
                while (j>i){
                    if(((starts[j]=='X'&&starts[j-1]=='R')||(starts[j]=='L'&&starts[j-1]=='X'))){
                        char temp=starts[j];
                        starts[j]=starts[j-1];
                        starts[j-1]=temp;
                        j--;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        String start="X";
        String end="L";
        System.out.println(canTransform(start,end));
    }
}
//L和R的相对位置应相同，且start中L的下标应大于end中L的下标，start中R的下标应小于end中R的下标
class Solution2 {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }
}