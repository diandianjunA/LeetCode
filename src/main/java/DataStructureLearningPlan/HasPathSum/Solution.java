package DataStructureLearningPlan.HasPathSum;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root,targetSum,0);
    }
    public boolean sum(TreeNode treeNode,int targetSum,int currentSum){
        if(treeNode==null){
            return false;
        }
        if(treeNode.val+currentSum==targetSum&&treeNode.left==null&&treeNode.right==null){
            return true;
        }
        if(sum(treeNode.left,targetSum,currentSum+ treeNode.val)||sum(treeNode.right,targetSum,currentSum+ treeNode.val)){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(-2);
        TreeNode treeNode1 = new TreeNode(-3);
        treeNode.right=treeNode1;
        System.out.println(hasPathSum(treeNode,-5));
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
class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}