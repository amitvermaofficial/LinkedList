package LinkedList.Problems;
import LinkedList.SinglyLinkedList;
import LinkedList.Node;
import java.util.Scanner;

// LeetCode 61.
public class RotateList {
    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) return head;
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        k %= size;
        if (k == 0) return head;
        Node slow = head;
        Node fast = head;
        for (int i=0; i<k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList sll = new SinglyLinkedList();
        RotateList obj = new RotateList();  
        System.out.print("Enter the number of elements in the list: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements of the list: ");
        for (int i=0; i<n; i++) {
            sll.insertAtTail(sc.nextInt());
        }
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        Node head = obj.rotateRight(sll.head, k);
        sll.head = head;
        sll.display();
        sc.close();
    }
}
