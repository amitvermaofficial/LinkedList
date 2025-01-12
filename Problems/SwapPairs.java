package LinkedList.Problems;
import LinkedList.Node;
import java.util.Scanner;
import LinkedList.SinglyLinkedList;

//LeetCode 24.
public class SwapPairs {
    public Node swapPairs(Node head) {
        if (head==null || head.next==null) return head;
        Node newHead = head.next;
        Node temp1 = head, temp2 = head.next;
        temp1.next = temp2.next;
        temp2.next = temp1;
        Node a = temp1;
        temp1 = a.next;
        if (a.next!=null) {
            temp2 = a.next.next;
        }
        while (temp1!=null && temp2!=null) {
            temp1.next = temp2.next;
            temp2.next = temp1;
            a.next = temp2;
            a = temp1;
            if(temp1!=null) temp1 = temp1.next;
            if(temp1!=null) temp2 = temp1.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList sll = new SinglyLinkedList();
        SwapPairs sp = new SwapPairs();
        System.out.print("Enter the elements of the linked list: ");
        while (sc.hasNextInt()) {
            sll.insertAtTail(sc.nextInt());
        }
        sc.next();
        Node head = sll.head;
        Node newHead = sp.swapPairs(head);
        sll.setHead(newHead);
        sll.display();
        sc.close();
    }
}
