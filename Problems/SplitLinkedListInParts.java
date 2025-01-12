package LinkedList.Problems;
import LinkedList.Node;
import LinkedList.SinglyLinkedList;

public class SplitLinkedListInParts {
    public int listLength(Node temp) {
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public Node[] splitListToParts(Node head, int k) {
        int length = listLength(head);
        Node temp = head;
        int size = length/k;
        int i = 0, len = 1;
        int extra = length%k;
        Node[] arr = new Node[k];
        while (temp != null) {
            int s = size;
            if (extra > 0) s++;
            if (len == 1) arr[i++] = temp;
            if (len == s) {
                Node a = temp.next;
                temp.next = null;
                temp = a;
                len = 1;
                extra--;
            } else {
                temp = temp.next;
                len++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtTail(1);
        sll.insertAtTail(2);
        sll.insertAtTail(3);
        sll.insertAtTail(4);
        sll.insertAtTail(5);
        sll.insertAtTail(6);
        sll.insertAtTail(7);
        sll.insertAtTail(8);
        sll.insertAtTail(9);
        sll.insertAtTail(10);
        SplitLinkedListInParts s = new SplitLinkedListInParts();
        Node[] arr = s.splitListToParts(sll.head, 3);
        for (Node node : arr) {
            sll.display(node);
            System.out.println();
        }
    }
    
}
