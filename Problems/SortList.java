package LinkedList.Problems;

import LinkedList.Node;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;

public class SortList {
    public Node merge(Node list1, Node list2) {
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

    public Node sortList(Node head) {
        if (head==null || head.next==null) return head;
        Node firstHalf = head;
        Node slow = head;
        Node fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }        
        Node secondHalf = slow.next;
        slow.next = null;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf); 
        Node ans = merge(firstHalf, secondHalf);
        return ans;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements of LinkedList: ");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        SortList obj = new SortList();
        Node head = obj.sortList(list.head);
        list.display(head);
        sc.close();
    }
}
