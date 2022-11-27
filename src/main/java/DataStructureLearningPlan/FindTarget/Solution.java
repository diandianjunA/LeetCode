package DataStructureLearningPlan.FindTarget;

import java.util.*;

public class Solution {
    List<Integer> temp= new ArrayList<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root!=null){
            if(temp.contains(root.val)){
                return true;
            }
            temp.add(k- root.val);
            return findTarget(root.left,k)||findTarget(root.right,k);
        }
        return false;
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}