package DataStructureLearningPlan.IsValidBST;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean isLeftValid=true;
        boolean isRightValid=true;
        if(root.left!=null){
            isLeftValid= getMax(root.left,root.left.val) < root.val && isValidBST(root.left);
        }
        if(root.right!=null){
            isRightValid=getMin(root.right,root.right.val)> root.val&&isValidBST(root.right);
        }
        return isLeftValid&&isRightValid;
    }
    public int getMin(TreeNode root,int min){
        if(root!=null){
            if(root.val<min){
                return getMin(root.left, root.val);
            }else{
                return getMin(root.left,min);
            }
        }
        return min;
    }
    public int getMax(TreeNode root,int max){
        if(root!=null){
            if(root.val>max){
                return getMax(root.right, root.val);
            }else {
                return getMax(root.right,max);
            }
        }
        return max;
    }
    @Test
    public void test(){

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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
class Solution3 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
class Solution4 {
    long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    // 中序遍历
    private boolean inorder(TreeNode node) {
        if(node == null) return true;
        boolean l = inorder(node.left);
        if(node.val <= pre) return false;
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }
}