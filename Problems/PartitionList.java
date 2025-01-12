package LinkedList.Problems;

import LinkedList.SinglyLinkedList;
import java.util.Scanner;
import LinkedList.Node;

public class PartitionList {
    public Node partition(Node head, int x) {
        if (head==null) return head;
        Node a = new Node(-1);   // dummy node
        Node b = new Node(-1);   // dummy node
        Node tempA = a;
        Node tempB = b;
        Node temp = head;
        while (temp != null) {
            if (temp.val < x) {
                tempA.next = temp;
                tempA = tempA.next;
            } else {
                tempB.next = temp;
                tempB = tempB.next;
            }
            temp = temp.next;
        }  
        tempB.next = null; // coz last node       
        tempA.next = b.next; // connect list a with list b
        return a.next; // return the head of the new list
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.print("Enter the elements of the Nodes of the Linked-list: ");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        System.out.print("Enter the value of x: ");
        sc.nextLine();   // to consume String input
        sc.nextLine(); // to consume nextLine Character/
        int x = sc.nextInt();

        PartitionList obj = new PartitionList();
        Node head = obj.partition(list.head, x);
        list.display(head);
        sc.close();
    }
}
