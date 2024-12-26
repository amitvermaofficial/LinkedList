package LinkedList;


class SinglyLinkedList {
    Node head;
    Node tail;
    int size;
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void insertAtHead(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void insertAtTail(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    void insert(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid index!!");
            return;
        }
        
        if (idx == 0) {
            insertAtHead(val);
            
        } else if (idx == size) {
            insertAtTail(val);
        } else {
            Node temp = new Node(val);
            Node prev = head;
            for (int i=1; i<idx; i++) {
                prev = prev.next;
            }
            // insertion
            temp.next = prev.next;
            prev.next = temp;
        }
        size++;
    }

    int getElement(int idx) throws Error {
        if (idx == size-1)
            return tail.val; 
        if (idx < 0 || idx >= size) {
            throw new Error ("Invalid Index!!");
        }
        Node temp = head;
        for (int i=0; i<idx; i++) {
            temp = temp.next;
        }
        
        return temp.val;
    }

    void delete(int idx) throws Error {
        if (idx > size-1 || idx < 0) {
            throw new Error("Index Not Existing!!");
        }

        Node temp = head;
        
        if (idx == 0) {
            head = head.next;
        } else {
            for (int i=1; i<idx; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
}

class Node {
    int val;
    Node next;

    Node(int n) {
        this.val = n;
    }
}

public class Implementation {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        System.out.println(a.val);
        System.out.println(b.next);
    }
}
