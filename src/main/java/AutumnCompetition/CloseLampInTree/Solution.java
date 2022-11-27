package AutumnCompetition.CloseLampInTree;


import org.junit.Test;

public class Solution {
    public int closeLampInTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (check(root)){
            return 0;
        }
        if(root.val==0){
            return closeLampInTree(root.left)+closeLampInTree(root.right);
        }
        Lock1(root);
        if(check(root)){
            return 1;
        }
        Lock1(root);
        Lock2(root);
        if(check(root)){
            return 1;
        }
        Lock2(root);
        Lock3(root);
        if(check(root)){
            return 1;
        }
        Lock3(root);
        Lock1(root);
        int method1=closeLampInTree(root.left)+closeLampInTree(root.right);
        OpenLampInTree(root.left);
        OpenLampInTree(root.right);
        Lock1(root);
        Lock2(root);
        int method2=closeLampInTree(root.left)+closeLampInTree(root.right);
        OpenLampInTree(root.left);
        OpenLampInTree(root.right);
        Lock2(root);
        Lock3(root);
        int method3=closeLampInTree(root.left)+closeLampInTree(root.right);
        OpenLampInTree(root.left);
        OpenLampInTree(root.right);
        Lock3(root);
        if(method1<Math.min(method2,method3)){
            Lock1(root);
            return method1+1;
        }
        if(method2<Math.min(method1,method3)){
            Lock2(root);
            return method2+1;
        }
        Lock3(root);
        return method3+1;
    }
    public int OpenLampInTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (checkR(root)){
            return 0;
        }
        if(root.val==0){
            return closeLampInTree(root.left)+closeLampInTree(root.right);
        }
        Lock1(root);
        if(checkR(root)){
            return 1;
        }
        Lock1(root);
        Lock2(root);
        if(checkR(root)){
            return 1;
        }
        Lock2(root);
        Lock3(root);
        if(checkR(root)){
            return 1;
        }
        Lock3(root);
        Lock3(root);
        Lock1(root);
        int method1=OpenLampInTree(root.left)+OpenLampInTree(root.right);
        Lock1(root);
        Lock2(root);
        int method2=OpenLampInTree(root.left)+OpenLampInTree(root.right);
        Lock2(root);
        Lock3(root);
        int method3=OpenLampInTree(root.left)+OpenLampInTree(root.right);
        Lock3(root);
        if(method1<Math.min(method2,method3)){
            Lock1(root);
            return method1+1;
        }
        if(method2<Math.min(method1,method3)){
            Lock2(root);
            return method2+1;
        }
        Lock3(root);
        return method3+1;
    }
    public boolean check(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.val!=0){
            return false;
        }
        return check(root.left)&&check(root.right);
    }
    public boolean checkR(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.val!=0){
            return false;
        }
        return check(root.left)&&check(root.right);
    }
    public void Lock1(TreeNode root){
        root.val=(root.val==1?0:1);
    }
    public void Lock2(TreeNode root){
        root.val=(root.val==1?0:1);
        if(root.left!=null){
            Lock2(root.left);
        }
        if(root.right!=null){
            Lock2(root.right);
        }
    }
    public void Lock3(TreeNode root){
        root.val=(root.val==1?0:1);
        if(root.left!=null){
            root.left.val=(root.left.val==1?0:1);
        }
        if(root.right!=null){
            root.right.val=(root.right.val==1?0:1);
        }
    }
    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;
        System.out.println(closeLampInTree(treeNode1));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}