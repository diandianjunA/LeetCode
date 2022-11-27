package DataStructureLearningPlan.DeleteDuplicates;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode listNode=head;
        while (head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }else {
                head=head.next;
            }
        }
        return listNode;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//递归
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        head.next=deleteDuplicates(head.next);
        return head.val==head.next.val?head.next:head;
    }
}