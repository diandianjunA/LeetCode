package EveryDayExercise.ReinitializePermutation;

import org.junit.Test;

public class Solution {
    public int reinitializePermutation(int n) {
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i]=i;
        }
        int res=0;
        boolean isReturn=true;
        do{
            isReturn=true;
            for (int i = 0; i < n; i++) {
                if(i%2==0){
                    arr2[i]=arr1[i/2];
                }else{
                    arr2[i]=arr1[n/2+(i-1)/2];
                }
                if(arr2[i]!=i){
                    isReturn=false;
                }
            }
            res++;
            int[] temp=arr1;
            arr1=arr2;
            arr2=temp;
        }while(!isReturn);
        return res;
    }

    @Test
    public void test1(){
        int n=4;
        System.out.println(reinitializePermutation(n));
    }
}
