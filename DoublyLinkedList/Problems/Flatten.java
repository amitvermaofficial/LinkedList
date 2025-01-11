package LinkedList.DoublyLinkedList.Problems;

class Node {
    int val;
    Node next;
    Node prev;
    Node child;
    Node(int val) {
        this.val = val;
    }
}

// Leetcode 430.
public class Flatten {
    public Node flatten(Node head) {
        Node temp = head;
        while (temp != null) {
            Node n = temp.next;
            if (temp.child != null) {
                Node c = flatten(temp.child);
                Node d = c;
                while (d.next != null) d = d.next;
                temp.next = c;
                c.prev = temp;
                d.next = n;
                if (n != null) n.prev = d;
                temp.child = null;
            }
            temp = n;
        }  
        return  head;      
    }

    public static void main(String[] args) {
        
    }
}
