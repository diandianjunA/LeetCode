package DataStructureLearningPlan;

import java.util.HashSet;

public class CircleList {
    public boolean hasCycle(ListNode2 head) {
        if(head==null){
            return false;
        }
        HashSet<ListNode2> list = new HashSet<>();
        while(head.next!=null){
            int size = list.size();
            list.add(head);
            if(size==list.size()){
                return true;
            }
            head=head.next;
        }
        return false;
    }
    //快慢指针法
    public boolean hasCyclePro(ListNode2 head) {
        ListNode2 s = head, f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f) return true;
        }
        return false;
    }
}
class ListNode2 {
     int val;
     ListNode2 next;
     ListNode2(int x) {
         val = x;
         next = null;
    }
}