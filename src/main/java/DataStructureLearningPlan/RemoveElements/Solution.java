package DataStructureLearningPlan.RemoveElements;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode();
        listNode.next=head;
        head=listNode;
        while(head.next!=null){
            if(head.next.val==val){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        return listNode.next;
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
