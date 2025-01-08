package LinkedList.Problems;
import LinkedList.Node;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;

public class ReverseLinkedList {

    // Recursive Method
    static Node reverseListRecursive(Node head) {
        if (head==null || head.next==null) return head;
        Node a = head.next;
        Node newHead = reverseListRecursive(a);
        a.next = head;
        head.next = null;
        return newHead;        
    }

    // Iterative Method
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node ahead = head;
        while (curr != null) {
            ahead = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }        
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.print("Enter elements of LinkedList: ");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        ReverseLinkedList obj = new ReverseLinkedList();
        Node head = obj.reverseList(list.head);
        list.display(head);
        sc.close();
    }
}
