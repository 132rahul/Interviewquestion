package Linkedlist;

public class Findtheloop {
    public static void main(String[] args) {
        CreateLinkedList lts = new CreateLinkedList();
        StartingOfLoop str = new StartingOfLoop();
        lts.providedata();
       // lts.head.next.next.next = lts.head;
        //CreateLinkedList head = null;
        //  System.out.println(lts.head.data);
        if (findloop(lts.head) == true) {
            System.out.println("Loop");
            System.out.println(str.findloopnode(lts.head));
        } else {
            System.out.println("No Loop");
            lts.display();
        }
    }

    private static boolean findloop(CreateLinkedList.Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        CreateLinkedList.Node slow = head;
        CreateLinkedList.Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
