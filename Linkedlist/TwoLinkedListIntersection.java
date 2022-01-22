package Linkedlist;

public class TwoLinkedListIntersection {
    static class Node1 {
        Node1 next1;
        int data1;

        Node1(int d) {
            data1 = d;
            next1 = null;
        }
    }

    private static Node1 head1, head2;

    public static void main(String[] args) {
        TwoLinkedListIntersection l1 = new TwoLinkedListIntersection();
        l1.head1 = new Node1(1);
        l1.head1.next1 = new Node1(2);
        l1.head1.next1.next1 = new Node1(3);
        l1.head1.next1.next1.next1 = new Node1(4);
        l1.head1.next1.next1.next1.next1 = new Node1(5);
        l1.head1.next1.next1.next1.next1.next1 = new Node1(6);

        System.out.println("dsdsd:  "+head1.data1);
        l1.head2 = new Node1(7);
        l1.head2.next1 = new Node1(8);
        l1.head2.next1.next1 = l1.head1.next1.next1.next1;
        display(head1);
        System.out.println();
        display(head2);
        System.out.println();
        System.out.println("The Lindked Node is: "+findintersection(head1, head2));
    }

    private static int findintersection(Node1 head1, Node1 head2) {
        int c1 = fintlenth(head1);
        int c2 = fintlenth(head2);
        int d = 0;
        int linkednode;
        if (c1 > c2) {
            d = c1 - c2;
            linkednode = getlinkednode(d, head1, head2);
        } else {
            d = c2 - c1;
            linkednode = getlinkednode(d, head2, head1);
        }
        return linkednode;
    }

    private static int getlinkednode(int d, Node1 nd1, Node1 nd2) {
        for (int i = 0; i < d; i++) {
            nd1 = nd1.next1;
        }
        while (nd1 != null) {
            if (nd1 == nd2) {
                return nd1.data1;
            }
            nd1 = nd1.next1;
            nd2 = nd2.next1;
        }
        return 1;
    }

    private static int fintlenth(Node1 nodect) {
        int count = 0;
        while (nodect.next1 != null) {
            count++;
            nodect = nodect.next1;
        }
        return count;
    }

    public static void display(Node1 nodept) {
        if (nodept == null) {
            System.out.println("empty");
        }
        while (nodept != null) {
            System.out.print(nodept.data1 + " ");
            nodept = nodept.next1;
        }
    }
}
