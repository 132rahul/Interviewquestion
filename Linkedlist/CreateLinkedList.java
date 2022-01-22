package Linkedlist;

public class CreateLinkedList {
    class Node {
        Node next;
        int data;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node head;

    public static void main(String[] args) {
        CreateLinkedList linkedList = new CreateLinkedList();
        linkedList.providedata();
        linkedList.display();

    }

    public void providedata() {
        adddata(12);
        adddata(13);
        adddata(14);
        adddata(15);
        adddata(16);
        adddata(17);
    }

    public void display() {
        if (head == null) {
            System.out.println("empty");
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public void adddata(int data) {
        Node NewNode = new Node(data);
        NewNode.next = head;
        head = NewNode;

    }
}
