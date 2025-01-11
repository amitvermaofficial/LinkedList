package LinkedList.DoublyLinkedList;

public class Implementation {
    public Node head;
    public Node tail;
    public int size;
    void insertAtTail(int val) {
        Node temp = new Node(val);
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }

    void insertAtHead(int val) {
        Node temp = new Node(val);
        if (size == 0) {
            head = tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    void insert(int i, int val) {
        if (i<0 || i>size) 
            throw new Error("Invalid Index .");
        if (i == 0) {
            insertAtHead(val);
            return;
        } else if (i == size) {
            insertAtTail(val);
        } else {
            Node temp = new Node(val);
            Node travNode = head;
            for (int j=1; j<i; j++) {
                travNode = travNode.next;
            }
            Node nextNode = travNode.next;
            travNode.next = temp;
            temp.next = nextNode;
            nextNode.prev = temp;
            temp.prev = travNode;
        }
        size++;
    }

    void delete(int i) {
        if (i<0 || i>=size)
            throw new Error("Invalid Index kyu daal rha hai bhai??");
        if (i == 0) {
            head.next.prev = null;
            head = head.next;
        } else if (i == size-1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            Node temp = head;
            for (int j=1; j<=i; j++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;
    }

    int get(int i) {
        if (i<0 || i>=size)
            throw new Error("Bhai yrr, Invalid Index hai...");
        if (i == 0) {
            return head.val;
        } else if (i == size-1) {
            return tail.val;
        } else {
            Node temp = head;
            for (int j=1; j<=i; j++) {
                temp = temp.next;
            }
            return temp.val;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Implementation list = new Implementation();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtHead(5);
        list.insert(4, 0);
        list.display();
        list.delete(4);
        list.display();
        System.out.println(list.get(2));
    }

}
