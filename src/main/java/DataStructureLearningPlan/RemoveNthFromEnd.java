package DataStructureLearningPlan;

public class RemoveNthFromEnd {
    //大佬解法递归
    int cur=0;
    public ListNode2 removeNthFromEndPro(ListNode2 head, int n) {
        if(head==null){
            return null;
        }
        head.next=removeNthFromEndPro(head.next,n);
        cur++;
        if(cur==n){
            return head.next;
        }
        return head;
    }
    //快慢指针法
    //快指针先走n步，然后快慢指针一起走，这时慢指针就会在要删除的位置处，因为跟着快指针一起走了length-n步，利用这个原理就能轻松找到要删除的节点及其前驱结点
    public ListNode2 removeNthFromEnd(ListNode2 head, int n){
        ListNode2 fast=head,slow=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        }
        fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
class ListNode {
      int val;
      ListNode2 next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode2 next) { this.val = val; this.next = next; }
}