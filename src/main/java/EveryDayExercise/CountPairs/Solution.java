package EveryDayExercise.CountPairs;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Tree tree = new Tree(new node(0));
        for (int j : nums) {
            tree.insert(j);
        }
        int res=0;
        for (int num : nums) {
            res = res + getNum(num, tree, high);
            res = res - getNum(num, tree, low - 1);
        }
        return res/2;
    }

    public int getNum(int num,Tree tree,int value){
        int sum=0;
        node temp=tree.root;
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(num));
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(value));
        if(s1.length()<16){
            int l=s1.length();
            for (int i = 0; i < 16 - l; i++) {
                s1.insert(0, '0');
            }
        }
        if(s2.length()<16){
            int l=s2.length();
            for (int i = 0; i < 16 - l; i++) {
                s2.insert(0, '0');
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i)=='1'){
                if(s1.charAt(i)=='1'){
                    if(temp.right!=null){
                        sum+=temp.right.value;
                    }
                    if(temp.left!=null){
                        temp=temp.left;
                    }else{
                        return sum;
                    }
                }else{
                    if(temp.left!=null){
                        sum+=temp.left.value;
                    }
                    if(temp.right!=null){
                        temp=temp.right;
                    }else{
                        return sum;
                    }
                }
            }else{
                if(s1.charAt(i)=='1'){
                    if(temp.right!=null){
                        temp=temp.right;
                    }else{
                        return sum;
                    }
                }else{
                    if(temp.left!=null){
                        temp=temp.left;
                    }else{
                        return sum;
                    }
                }
            }
        }
        return sum+ temp.value;
    }

    @Test
    public void test1(){
        int[] nums={1,4,2,7};
        int low=2;
        int high=6;
        System.out.println(countPairs(nums,low,high));
    }

    @Test
    public void test2(){
        int[] nums={9,8,4,2,1};
        int low=5;
        int high=14;
        System.out.println(countPairs(nums,low,high));
    }
}

class Tree{
    node root;

    public Tree(node root) {
        this.root = root;
    }

    public void insert(int value){
        node temp=root;
        StringBuilder s = new StringBuilder(Integer.toBinaryString(value));
        if(s.length()<16){
            int l=s.length();
            for (int i = 0; i < 16 - l; i++) {
                s.insert(0, '0');
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                if(temp.left==null){
                    temp.left=new node(0);
                }
                temp=temp.left;
            }else{
                if(temp.right==null){
                    temp.right=new node(0);
                }
                temp=temp.right;
            }
            temp.value++;
        }
    }
}

class node{
    int value;
    node left;
    node right;

    public node(int value) {
        this.value = value;
    }
}