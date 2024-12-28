package LinkedList.Problems;
import LinkedList.SinglyLinkedList;
import LinkedList.Node;

public class RemoveDuplicatesFromSortedList {
    public Node deleteDuplicates2(Node head) {
        if (head == null)
            return head;
        Node a = head;
        Node b = head;
        while (b != null) {
            if (a.val != b.val) {
                a.next = b;
                a = b;
            } else {
                b = b.next;
            }
        }
        a.next = null;
        return head;
    }

    static Node deleteDuplicates(Node head) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(12);
        list.insertAtTail(12);
        list.insertAtTail(12);
        list.insertAtTail(12);
        list.insertAtTail(12);
        list.insertAtTail(15);
        list.insertAtTail(15);
        list.insertAtTail(16);
        list.insertAtTail(17);
        list.insertAtTail(17);
        list.insertAtTail(17);
        list.insertAtTail(78);
        list.insertAtTail(78);
        Node head = deleteDuplicates(list.head);
        list.display();
    }
}
