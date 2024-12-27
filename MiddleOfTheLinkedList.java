package LinkedList;
// slow-fast approach.
import java.util.Scanner;
// LeetCode 876.

/*
 * Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

 */
public class MiddleOfTheLinkedList {
    static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        } 
        return slow;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Linked List : ");
        int n = sc.nextInt();
        System.out.printf("Enter %d elements : \n", n);
        for (int i=0; i<n; i++) {
            list.insertAtTail(sc.nextInt());
        }

        Node middle = middleNode(list.head);

        System.out.println("Elements from middle of the Linked-List.");
        while (middle!=null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }
        sc.close();
    }
}
