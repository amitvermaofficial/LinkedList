package LinkedList.Problems;
import LinkedList.SinglyLinkedList;
import LinkedList.Node;

public class LinkedListCycle2 {
    public Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        boolean flag = false;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return null;
        Node temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
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
        LinkedListCycle2 obj = new LinkedListCycle2();
        Node cycle = obj.detectCycle(list.head);
        if (cycle == null) {
            System.out.println("No cycle found!!");
        } else {
            System.out.println("Cycle detected at : " + cycle.val);
        }
    }
}
