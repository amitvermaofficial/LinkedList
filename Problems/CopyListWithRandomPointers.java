package LinkedList.Problems;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointers {
    class Solution {
        public Node deepCopy(Node head) {
            Node head2 = new Node(head.val);
            Node temp1 = head.next, temp2 = head2;
            while (temp1 != null) {
                Node temp = new Node(temp1.val);
                temp2.next = temp;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return head2;
        }
        public void connectAlternatively(Node head1, Node head2) {
            Node t1 = head1, t2 = head2;
            Node dummy = new Node(-1);
            Node t = dummy;
            while (t1!=null && t2!=null) {
                t.next = t1;
                t1 = t1.next;
                t = t.next;
                t.next = t2;
                t2 = t2.next;
                t = t.next;
            }
        }
        public void assignRandom(Node head1, Node head2) {
            Node t1 = head1;
            Node t2 = head2;
            while (t1!=null && t2!=null) {
                t2 = t1.next;
                if (t1.random!=null) t2.random = t1.random.next;
                t1 = t1.next.next;
            }
        }
        public void split(Node head1, Node head2) {
            Node t1 = head1, t2 = head2;
            while (t1!=null && t2!=null) {
                t1.next = t2.next;
                t1 = t1.next;
                if (t1==null) break;
                t2.next = t1.next;
                t2 = t2.next;
            }
        }
        public Node copyRandomList(Node head) {
            if (head==null) return head;
            // step1: create deepCopy w/o random connections.
            Node head2 = deepCopy(head);        
            // step2: join head and head2 alternatively.
            connectAlternatively(head, head2);
            // step3: Assign Random Pointers.
            assignRandom(head, head2);
            // step4: split the lists.
            split(head, head2);
            return head2;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointers cl = new CopyListWithRandomPointers();
        Solution s = cl.new Solution();
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node head2 = s.copyRandomList(head);
        while (head2!=null) {
            System.out.println(head2.val);
            head2 = head2.next;
        }
    }
    
}