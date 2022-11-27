package DataStructureLearningPlan;

import java.util.Stack;

public class MergeTwoLists {
    public ListNode3 mergeTwoLists(ListNode3 list1, ListNode3 list2) {
        Stack<ListNode3> stack = new Stack<>();
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                stack.push(list1);
                list1=list1.next;
            }else {
                stack.push(list2);
                list2=list2.next;
            }
        }
        if (list1==null){
            while(list2!=null){
                stack.push(list2);
                list2=list2.next;
            }
        }else{
            while (list1!=null){
                stack.push(list1);
                list1=list1.next;
            }
        }
        ListNode3 res = new ListNode3();
        while (!stack.isEmpty()){
            ListNode3 node = stack.pop();
            node.next=res.next;
            res.next=node;
        }
        return res.next;
    }
    //递归解决
    public ListNode3 mergeTwoListsPro(ListNode3 l1, ListNode3 l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsPro(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsPro(l1, l2.next);
            return l2;
        }
    }
    public ListNode3 mergeTwoListsPro2(ListNode3 l1, ListNode3 l2) {
        ListNode3 prehead = new ListNode3(-1);

        ListNode3 prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
 }