package LinkedList;

public class ListNodeClass {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        // System.out.println("\n"+b.val + " " + b.next); // b ka value and c ka address 
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        a.next = b; // a linked with b [a.val, b ka address];
        b.next = c; // same if we comment b .next=c it shows an error coz linking breaks.
        c.next = d; // same
        d.next = e; // same
        System.out.println(a.val); // printing value of a
        System.out.println(a.next.val); // printing value of b
        System.out.println(a.next.next.val); // printing value of c
        System.out.println();
        System.out.println(a.next.next.next.next.next); // printing next node address of e(which is null).
    }
}
