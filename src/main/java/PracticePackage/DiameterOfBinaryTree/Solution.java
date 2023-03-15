package PracticePackage.DiameterOfBinaryTree;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftNum=diameterOfBinaryTree(root.left);
        int rightNum=diameterOfBinaryTree(root.right);
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left+right,Math.max(leftNum,rightNum));
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left,right);
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
