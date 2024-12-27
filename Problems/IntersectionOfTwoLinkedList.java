package LinkedList.Problems;
import LinkedList.SinglyLinkedList;

import LinkedList.Node;

// LeetCode 160.
public class IntersectionOfTwoLinkedList {
    static Node getIntersectionNode(Node headA, Node headB) {
        Node tempA = headA;
        Node tempB = headB;
        int lenA = 1, lenB = 1;
        while (tempA != null) {
            tempA = tempA.next;
            lenA++;
        } 
        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }       
        int diff = lenA-lenB;
        tempA = headA;
        tempB = headB;
        if (diff < 0) {
            for (int i=0; i<Math.abs(diff); i++) {
                tempB = tempB.next;
            }
        } else {
            for (int i=0; i<Math.abs(diff); i++) {
                tempA = tempA.next;
            }
        }

        while (tempA!=tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list1.insertAtTail(1);
        list1.insertAtTail(2);
        list1.insertAtTail(3);
        list1.insertAtTail(4);
        list1.insertAtTail(5);
        list1.insertAtTail(6);
        list1.insertAtTail(7);
        list1.insertAtTail(8);
        list2.insertAtTail(11);
        list2.insertAtTail(12);
        list2.insertAtTail(13);
        list2.insertAtTail(14);
        list2.insertAtTail(15);
        Node temp1 = getIntersectionNode(list1.head, list2.head);
        if (temp1 == null) {
            System.out.println("No intersection point found!!");
        } else {
            System.out.println("Intersection point is : " + temp1.val);
        }
    }
}
