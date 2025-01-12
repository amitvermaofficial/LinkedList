package LinkedList.Problems;
import LinkedList.Node;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;


public class ReorderList {

    public void reorderList(Node head) {
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }     
        System.out.println(1);
        prev.next = null;
        Node curr = slow, ahead = slow;
        prev = null;
        while (curr != null) {
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        Node secondHalf = prev;
        while (secondHalf!=null) {
            System.out.print(secondHalf.val + " ");
            secondHalf = secondHalf.next;
        } 
        Node first = head, second = secondHalf;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        sc.next();
        ReorderList obj = new ReorderList();
        obj.reorderList(list.head);
        list.display();
        sc.close();        
    }
}