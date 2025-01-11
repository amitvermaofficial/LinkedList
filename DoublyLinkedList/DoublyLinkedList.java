package LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);

        head.next = node1;
        node1.prev = head;

        node1.next = node2;
        node2.prev = node1;

        node2.next = node3;
        node3.prev = node2;

        System.out.print("Using next pointer: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
            
        }

        System.out.print("\nUsing prev pointer: ");
        while (node3 != null) {
            System.out.print(node3.val + " ");
            node3 = node3.prev; 
        }
    }
}
