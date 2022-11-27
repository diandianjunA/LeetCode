package DataStructureLearningPlan.SearchBST;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode treeNodeLeft = searchBST(root.left, val);
        if(treeNodeLeft!=null){
            return treeNodeLeft;
        }
        TreeNode treeNodeRight = searchBST(root.right, val);
        if(treeNodeRight!=null){
            return treeNodeRight;
        }
        return null;
    }
    public TreeNode searchBSTPro(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        return (root.val<val?searchBSTPro(root.right,val):searchBSTPro(root.left,val));
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
//迭代法
class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }
}