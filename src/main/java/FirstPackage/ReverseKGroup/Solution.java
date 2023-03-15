package FirstPackage.ReverseKGroup;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode temp=head;
        int i=1;
        while(temp.next!=null&&i<k){
            i++;
            temp=temp.next;
        }
        if(i<k){
            return head;
        }
        ListNode tail=temp.next;
        ListNode res=new ListNode();
        res.next=head;
        temp=head.next;
        ListNode index=temp;
        while(temp!=tail){
            temp=temp.next;
            index.next=res.next;
            res.next=index;
            index=temp;
        }
        head.next=reverseKGroup(tail,k);
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}