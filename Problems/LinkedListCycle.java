package LinkedList.Problems;
import LinkedList.SinglyLinkedList;
import LinkedList.Node;

public class LinkedListCycle {
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) 
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);
        list.insertAtTail(7);
        list.insertAtTail(8);
        list.head.next.next.next.next.next.next.next.next = list.head.next.next.next.next;
        LinkedListCycle obj = new LinkedListCycle();
        System.out.println(obj.hasCycle(list.head));    
        
    }
}
