package LinkedList.Problems;
import LinkedList.Node;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;

public class RemoveNthNodeFromBackOfLL {

    public int length(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if (head==null || head.next==null) return null;
        int len = length(head);
        int idx = len-n;  
        if (idx==0) return head.next;
        Node temp = head;
        for (int i=1; i<idx; i++) {
            temp = temp.next;
        }      
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elenents of the linked list: ");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        sc.next();

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        RemoveNthNodeFromBackOfLL obj = new RemoveNthNodeFromBackOfLL();
        Node head = obj.removeNthFromEnd(list.head, n);
        list.display(head);
        sc.close();
    }
}
