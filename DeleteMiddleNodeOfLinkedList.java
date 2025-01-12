package LinkedList;

import java.util.Scanner;

public class DeleteMiddleNodeOfLinkedList {
    static Node deleteMiddle(Node head) {
        if (head == null) {
            return null;
        }        
        Node prev = head;
        Node slow = head;
        Node fast = head;
        if (fast.next == null) {
            return null;
        }
        while (fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.print("Enter the size of Linked-List : ");
        int n = sc.nextInt();
        System.out.printf("Enter %d elements : ", n);
        for (int i=0; i<n; i++) {
            list.insertAtTail(sc.nextInt());
        }

        list.head = deleteMiddle(list.head);

        System.out.println("Linked-List after deleting middle element :");
        list.display();
        sc.close();
    }
}
