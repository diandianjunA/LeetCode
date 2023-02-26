package EveryDayExercise.BtreeGameWinningMove;

import org.junit.Test;

public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode treeNode = find(root, x);
        int left=count(treeNode.left);
        int right=count(treeNode.right);
        int father=n-left-right-1;
        return left > right + father + 1 || right > left + father + 1 || father > left + right + 1;
    }
    public TreeNode find(TreeNode root,int x){
        if(root.val==x){
            return root;
        }
        if(root.left!=null){
            TreeNode treeNode = find(root.left, x);
            if(treeNode!=null){
                return treeNode;
            }
        }
        if(root.right!=null){
            TreeNode treeNode = find(root.right, x);
            if(treeNode!=null){
                return treeNode;
            }
        }
        return null;
    }
    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }

    @Test
    public void test1(){
        TreeNode treeNode = null;
        int n=11;
        int x=3;
        System.out.println(btreeGameWinningMove(treeNode,n,x));
    }

    @Test
    public void test2(){
        TreeNode treeNode = null;
        int n=3;
        int x=1;
        System.out.println(btreeGameWinningMove(treeNode,n,x));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}