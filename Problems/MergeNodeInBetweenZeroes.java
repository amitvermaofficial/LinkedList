package LinkedList.Problems;
import LinkedList.Node;
import java.util.Scanner;
import LinkedList.SinglyLinkedList;

public class MergeNodeInBetweenZeroes {
    public Node mergeNodes(Node head) {
        Node dummy = new Node(-1);
        Node trav = dummy;
        int sum = 0;
        while (head != null) {
            if (head.val == 0) {
                if (sum != 0) {
                    trav.next = new Node(sum);
                    trav = trav.next;
                    sum = 0;
                }
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements of LinkedList: ");
        System.out.println("NOTE : starting and ending should must be zero.");
        System.out.println("In between zeroes allowed, the nodes will be merged.");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        MergeNodeInBetweenZeroes obj = new MergeNodeInBetweenZeroes();
        Node head = obj.mergeNodes(list.head);
        list.display(head);
        sc.close();
    }
}
