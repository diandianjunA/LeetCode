package EveryDayExercise.MergeInBetween;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode from=list1;
        ListNode to;
        for (int i = 0; i < a-1; i++) {
            from=from.next;
        }
        to=from.next;
        for (int i = a; i < b+1; i++) {
            to=to.next;
        }
        from.next=list2;
        while (list2.next!=null){
            list2=list2.next;
        }
        list2.next=to;
        return list1;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}