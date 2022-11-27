package EveryDayExercise.ThreeEqualParts;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] threeEqualParts(int[] arr) {
        int first=arr[0];
        int second=0;
        int third=0;
        for (int i = 0; i < arr.length-2; i++) {
            first=calculate(arr,0,i);
            for (int j = i+2; j < arr.length; j++) {
                second=calculate(arr,i+1,j-1);
                third=calculate(arr,j,arr.length-1);
                if(first==second&&second==third){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public int calculate(int[] arr,int start,int end){
        int res=arr[start];
        for (int i = start+1; i <= end; i++) {
            res=res*2+arr[i];
        }
        return res;
    }
    @Test
    public void test(){
        int[] arr={1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0};
        System.out.println(Arrays.toString(Solution2.threeEqualParts(arr)));
    }
}
class Solution2{
    public static int[] threeEqualParts(int[] arr) {
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                index++;
            }
        }
        if(index==0){
            return new int[]{0,2};
        }
        if(index%3!=0){
            return new int[]{-1,-1};
        }
        int num1=0;
        int num2=0;
        int num3=0;
        boolean flag=true;
        int space1=0,space2=0;
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        int p,q;
        for (i = 0; num1 < index/3; i++) {
            if(flag&&arr[i]==0){
            }else{
                flag=false;
                if(arr[i]==0){
                    list.add(0);
                }else {
                    num1++;
                    list.add(1);
                }
            }
        }
        p=i-1;
        flag=true;
        for (; num2 < index/3; i++) {
            if(flag&&arr[i]==0){
                space1++;
            }else{
                flag=false;
                for (int temp:list){
                    if(temp!=arr[i]){
                        return new int[]{-1,-1};
                    }
                    num2+=temp;
                    i++;
                }
            }
        }
        i--;
        q=i;
        flag=true;
        for(;num3<index/3;i++){
            if(flag&&arr[i]==0){
                space2++;
            }else{
                flag=false;
                for (int temp:list){
                    if(temp!=arr[i]){
                        return new int[]{-1,-1};
                    }
                    num3+=temp;
                    i++;
                }
            }
        }
        i--;
        if(space1>=arr.length-i&&space2>=arr.length-i){
            return new int[]{p+arr.length-i,q+arr.length-i};
        }else{
            return new int[]{-1,-1};
        }
    }
}
class Solution3 {
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }

        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }
}