package DataStructureLearningPlan.MyHashMapTree;

public class Solution {

}
class MyHashMap {

    Tree tree;

    public MyHashMap() {
        tree=new Tree();
    }

    public void put(int key, int value) {
        tree.insert(new Node(key,value));
    }

    public int get(int key) {
        Node node = tree.get(key);
        if(node==null){
            return -1;
        }else{
            return node.value;
        }
    }

    public void remove(int key) {
        tree.remove(key);
    }
}
class Tree{
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {

    }

    public void insert(Node node){
        if(root==null){
            root=node;
        }else{
            root.insert(node);
        }
    }
    public Node get(int key){
        if(root==null){
            return null;
        }else{
            return root.get(key);
        }
    }
    public void remove(int key){
        if(root==null){
            return;
        }
        if(root.key==key){
            if(root.left==null&&root.right==null){
                root=null;
            }else if(root.left!=null&&root.right!=null){
                Node node = deleteRightTreeMin(root.right);
                root.key=node.key;
                root.value=node.value;
            }else {
                if (root.left==null){
                    root=root.right;
                }else{
                    root=root.left;
                }
            }
        }else{
            Node node = get(key);
            if(node==null){
                return;
            }
            Node parent = getParent(key);
            if(node.left==null&&node.right==null){
                if(node==parent.left){
                    parent.left=null;
                }else if(node==parent.right){
                    parent.right=null;
                }
            }else if(node.left!=null&&node.right!=null){
                Node min = deleteRightTreeMin(node.right);
                node.key= min.key;
                node.value= min.value;
            }else{
                if(node.left==null){
                    if(node==parent.left){
                        parent.left=node.right;
                    } else if (node == parent.right) {
                        parent.right=node.right;
                    }
                }else {
                    if(node==parent.left){
                        parent.left=node.left;
                    } else if (node == parent.right) {
                        parent.right=node.left;
                    }
                }
            }
        }
    }
    public Node deleteRightTreeMin(Node node){
        Node target=node;
        while(target.left!=null){
            target=target.left;
        }
        remove(target.key);
        return target;
    }
    public Node getParent(int key){
        if(root==null){
            return null;
        }
        return root.getParent(key);
    }
}
class Node{
    Node left;
    Node right;
    int key;
    int value;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public void insert(Node node){
        if(key==node.key){
            value=node.value;
            return;
        }
        if(key>node.key){
            if(left==null){
                left=node;
            }else{
                left.insert(node);
            }
        }else{
            if(right==null){
                right=node;
            }else{
                right.insert(node);
            }
        }
        if(leftHeight()-rightHeight()>1){
            if(left!=null&&left.rightHeight()>left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }else if(rightHeight()-leftHeight()>1){
            if(right!=null&&right.leftHeight()>right.rightHeight()){
                right.rightRotate();
            }
            leftRotate();
        }
    }
    public Node get(int key){
        if(this.key==key){
            return this;
        }
        if(this.key>key){
            if(left==null){
                return null;
            }else {
                return left.get(key);
            }
        }
        if(right==null){
            return null;
        }else {
            return right.get(key);
        }
    }
    public Node getParent(int key){
        if(this.left!=null){
            if(this.left.key==key){
                return this;
            }
            if(this.key>key){
                return left.getParent(key);
            }
        }
        if(this.right!=null){
            if(this.right.key==key){
                return this;
            }
            if(this.key<key){
                return right.getParent(key);
            }
        }
        return null;
    }
    public void leftRotate(){
        Node node = new Node(key,value);
        node.right=right.left;
        node.left=left;
        this.key=this.right.key;
        this.value=this.right.value;
        this.right=this.right.right;
        this.left=node;
    }
    public void rightRotate(){
        Node node = new Node(key, value);
        node.left=left.right;
        node.right=right;
        this.key=this.left.key;
        this.value=this.left.value;
        this.left=this.left.left;
        this.right=node;
    }
    public int height(){
        int le = leftHeight();
        int ri = rightHeight();
        return Math.max(le, ri);
    }
    public int leftHeight(){
        if(left!=null){
            return 1+left.height();
        }else{
            return 0;
        }
    }
    public int rightHeight(){
        if(right!=null){
            return 1+right.height();
        }else{
            return 0;
        }
    }
}