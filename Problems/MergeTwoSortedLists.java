package LinkedList.Problems;

import LinkedList.SinglyLinkedList;
import java.util.Scanner;
import LinkedList.Node;


public class MergeTwoSortedLists {
    public Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node temp1 = list1;
        Node temp2 = list2;
        while (temp1!=null && temp2!=null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }        
        if (temp1 == null) temp.next = temp2;
        else temp.next = temp1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        System.out.println("Enter elements of first sorted LinkedList: ");
        while (sc.hasNextInt()) {
            list1.insertAtTail(sc.nextInt());
        }
        System.out.println("Enter elements of second sorted LinkedList: ");
        while (sc.hasNextInt()) {
            list2.insertAtTail(sc.nextInt());
        }
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        Node head = obj.mergeTwoLists(list1.head, list2.head);
        list1.display(head);
        sc.close();
    }
}
