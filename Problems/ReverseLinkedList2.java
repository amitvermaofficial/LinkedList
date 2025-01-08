package LinkedList.Problems;
import LinkedList.Node;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;

public class ReverseLinkedList2 {
    public void reverseList(Node head) {
        Node prev = null, curr = head, ahead = head;
        while (curr != null) {
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
    }

    public Node reverseBetween(Node head, int left, int right) {
        Node a = null, b = null, c = null, d = null;
        int pos = 1;
        Node temp = head;
        while (temp != null) {
            if (pos==left-1) a = temp;
            if (pos==left) b = temp;
            if (pos==right) c = temp;
            if (pos==right+1) d = temp;
            temp = temp.next;
            pos++;
        }        

        if (a != null) a.next = null;
        if (c != null) c.next = null;
        reverseList(b);
        if (a != null ) a.next = c;
        b.next = d;
        if (a == null) 
            return c;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.print("Enter elements of LinkedList: ");
        while (sc.hasNextInt()) {
            list.insertAtTail(sc.nextInt());
        }
        sc.next();
        ReverseLinkedList2 obj = new ReverseLinkedList2();
        System.out.println("NOTE : left and right are 1-based index..");
        System.out.println("NOTE : left < right and it is must..");
        System.out.print("Enter left and right: ");
        int left = sc.nextInt();
        int right = sc.nextInt();
        Node head = obj.reverseBetween(list.head, left, right);
        list.display(head);
        sc.close();
    }
}
