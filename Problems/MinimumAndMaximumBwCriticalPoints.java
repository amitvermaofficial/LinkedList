package LinkedList.Problems;
import java.util.Scanner;

import LinkedList.Node;
import LinkedList.SinglyLinkedList;
public class MinimumAndMaximumBwCriticalPoints {
    public int[] nodesBetweenCriticalPoints(Node head) {
        Node left = head;
        Node mid = head.next;
        Node right = head.next.next;
        int first = -1, last = -1;
        int minDistance = Integer.MAX_VALUE;
        int idx = 1;        
        while (right != null) {
            if ((left.val<mid.val && mid.val>right.val) || (left.val>mid.val && right.val>mid.val)) {
                if (first == -1) {
                    first = idx;
                }
                if (last != -1) {
                    int dist = idx - last;
                    minDistance = Math.min(minDistance, dist);
                }
                last = idx;
            } 
            left = left.next;
            mid = mid.next;
            right = right.next;
            idx++;   
        }
        int[] arr = {-1, -1};
        if (first == last) return arr;
        arr[0] = minDistance;
        arr[1] = last - first;
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Enter the number of elements in the list:");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            list.insertAtTail(sc.nextInt());
        }
        MinimumAndMaximumBwCriticalPoints solution = new MinimumAndMaximumBwCriticalPoints();
        int[] result = solution.nodesBetweenCriticalPoints(list.head);
        System.out.println("Minimum distance: " + result[0]);
        System.out.println("Maximum distance: " + result[1]);
        sc.close();
    }
}
