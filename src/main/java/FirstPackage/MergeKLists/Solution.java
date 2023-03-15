package FirstPackage.MergeKLists;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode();
        ListNode res=temp;
        while(true){
            int min=0;
            boolean quit=true;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(lists[min]==null){
                        min=i;
                    }else if (lists[i].val<lists[min].val) {
                        min = i;
                    }
                    quit = false;
                }
            }
            if(quit){
                break;
            }
            temp.next=new ListNode(lists[min].val);
            temp=temp.next;
            lists[min]=lists[min].next;
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