package LinkedList.Problems;
import LinkedList.Node;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;

public class PalindromeLinkedList {
    public boolean isPalindrome(Node head) {
        if (head.next == null) return true;

        // Find the middle of the linked-list.
        Node slow = head, fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the Linked-List.
        Node prev = null, curr = slow, ahead = slow;
        while (curr != null) {
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }

        // Compare the first half and the reversed second half of the Linked-List.
        Node firstHalf = head;
        Node secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements of LinkedList: ");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        PalindromeLinkedList obj = new PalindromeLinkedList();
        boolean ans = obj.isPalindrome(list.head);
        System.out.println(ans);
        sc.close();
    }
}
