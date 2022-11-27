package EveryDayExercise;

public class MyLinkedList {
    Node head=new Node();
    int length;

    public MyLinkedList() {
        length=0;
    }

    public int get(int index) {
        if(index>=length||index<0){
            return -1;
        }
        Node temp=head;
        for (int i = 0; i < index+1; i++) {
            temp=temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next=head.next;
        head.next=node;
        length++;
    }

    public void addAtTail(int val) {
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node node = new Node(val);
        temp.next=node;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if(index>length){
        }else if (index<0){
            Node node = new Node(val);
            node.next=head.next;
            head.next=node;
            length++;
        }else{
            Node temp=head;
            Node node = new Node(val);
            for (int i = 0; i < index; i++) {
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=node;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index>=length||index<0){
            return;
        }else{
            Node temp=head;
            for (int i = 0; i < index; i++) {
                temp=temp.next;
            }
            temp.next=temp.next.next;
            length--;
        }
    }
}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }

}