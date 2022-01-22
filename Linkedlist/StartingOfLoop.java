package Linkedlist;

public class StartingOfLoop {
    CreateLinkedList lts = new CreateLinkedList();
    public int findloopnode(CreateLinkedList.Node head){
        CreateLinkedList.Node slow = head;
        CreateLinkedList.Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                CreateLinkedList.Node cur=head;
                if(cur==fast){
                    return cur.data;
                }
                cur=cur.next;
                fast=fast.next;
            }
        }
        return 0;
    }
}
