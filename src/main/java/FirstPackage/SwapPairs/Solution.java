package FirstPackage.SwapPairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode();
        ListNode res=temp;
        temp.next=head;
        while(temp!=null&&temp.next!=null&&temp.next.next!=null){
            ListNode temp1=temp.next;
            ListNode temp2=temp.next.next;
            temp1.next=temp2.next;
            temp.next=temp2;
            temp2.next=temp1;
            temp=temp.next.next;
        }
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