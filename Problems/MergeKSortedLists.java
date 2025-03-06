package LinkedList.Problems;

import java.util.*;

public class MergeKSortedLists {
    static Node mergeList(Node l1, Node l2) {
        Node l = new Node(-1);
        Node temp = l;
        Node temp1 = l1;
        Node temp2 = l2;
        while (temp1!=null && temp2!=null) {
            if (temp2.val > temp1.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 == null) temp.next = temp2;
        else temp.next = temp1;
        return l.next;
    }

    public Node mergeKLists(Node[] lists) {
        int n = lists.length;
        if (n == 1)
            return lists[0];
        if (n == 0)
            return null;
        ArrayList<Node> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            arr.add(lists[i]);
        }

        while (arr.size() > 1) {
            Node l1 = arr.get(arr.size()-1);
            arr.remove(l1);
            Node l2 = arr.get(arr.size()-1);
            arr.remove(l2);
            Node l = mergeList(l1, l2);
            arr.add(l);
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        Node[] lists = new Node[3];
        
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);
        
        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);
        
        lists[2] = new Node(2);
        lists[2].next = new Node(6);
        
        MergeKSortedLists obj = new MergeKSortedLists();
        Node result = obj.mergeKLists(lists);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
