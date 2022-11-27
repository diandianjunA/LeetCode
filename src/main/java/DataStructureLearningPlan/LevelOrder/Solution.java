package DataStructureLearningPlan.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int level = getLevel(root, 1);
        for (int i = 0; i < level; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            res.add(list);
        }
        getLevelOrder(res,root,0);
        return res;
    }
    public int getLevel(TreeNode treeNode,int index){
        if(treeNode==null){
            return index-1;
        }
        return Math.max(getLevel(treeNode.left,index+1),getLevel(treeNode.right,index+1));
    }
    public void getLevelOrder(List<List<Integer>> res,TreeNode treeNode,int level){
        if(treeNode==null){
            return;
        }
        res.get(level).add(treeNode.val);
        getLevelOrder(res,treeNode.left,level+1);
        getLevelOrder(res,treeNode.right,level+1);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}