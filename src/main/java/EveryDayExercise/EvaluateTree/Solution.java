package EveryDayExercise.EvaluateTree;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val<=1){
            return root.val == 1;
        }else {
            if(root.val==2){
                return evaluateTree(root.left)||evaluateTree(root.right);
            }else {
                return evaluateTree(root.left)&&evaluateTree(root.right);
            }
        }
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