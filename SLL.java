package LinkedList;

// singly Linked List's class is in Implementation.java
public class SLL {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtTail(60);
        
        list.insertAtTail(70);
        list.insertAtHead(67);
        list.insertAtHead(25);
        list.insertAtHead(23);

        list.insertAtHead(90);
        list.display();
        System.out.println(list.size);

        list.insert(3, 35);
        list.display();
        System.out.println(list.size);

        // list.insert(5, 80);
        // list.display();
        // list.insert(18, 0);
        // System.out.println(list.getElement(1));
        list.delete(5);
        list.display();
        System.out.println(list.size);
    }
}
