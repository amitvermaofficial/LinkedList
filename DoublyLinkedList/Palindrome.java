package LinkedList.DoublyLinkedList;

public class Palindrome {
    static boolean isPlaindrome(Node head, Node tail) {
        Node forw = head, back = tail;
        while (forw != tail) {
            if (forw.val !=  back.val)
                return false;
            forw = forw.next;
            back = back.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head1 = new Node(10);
        Node node1 = new Node(20);
        head1.next = node1;
        node1.prev = head1;
        Node node2 = new Node(30);
        node1.next = node2;
        node2.prev = node1;
        Node node3 = new Node(20);
        node2.next = node3;
        node3.prev = node2;
        Node tail1 = new Node(10);
        node3.next = tail1;
        tail1.prev = node3;

        System.out.println("Palindrome status: "+isPlaindrome(head1, tail1));
    }
}
