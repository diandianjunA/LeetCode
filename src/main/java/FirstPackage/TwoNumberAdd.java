package FirstPackage;

//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以0开头。
//
public class TwoNumberAdd {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //我的解法
    //执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
    //内存消耗：41.9 MB, 在所有 Java 提交中击败了8.29%的用户
    //通过测试用例：1568 / 1568
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int more=0;
        ListNode index=null;
        ListNode head=null;
        while(l1!=null&&l2!=null){
            ListNode result = new ListNode();
            result.val=(l1.val+l2.val+more)%10;
            more=(l1.val+l2.val+more)/10;
            if(index!=null){
                index.next=result;
            }else{
                head=result;
            }
            index=result;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            while(l2!=null){
                ListNode result = new ListNode();
                result.val=(l2.val+more)%10;
                more=(l2.val+more)/10;
                index.next=result;
                index=result;
                l2=l2.next;
            }
        }else if(l2==null){
            while(l1!=null){
                ListNode result = new ListNode();
                result.val=(l1.val+more)%10;
                more=(l1.val+more)/10;
                index.next=result;
                index=result;
                l1=l1.next;
            }
        }
        if(more!=0){
            ListNode result = new ListNode();
            result.val=more;
            index.next=result;
        }
        return head;
    }
}
