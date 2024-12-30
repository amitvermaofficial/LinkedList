package LinkedList.Problems;
// LeetCode Problems - 2326.
import LinkedList.SinglyLinkedList;
import LinkedList.Node;
import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, Node head) {
        int[][] matrix = new int[m][n];
        int topRow = 0, bottomRow = m-1;
        int leftCol = 0, rightCol = n-1;
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        while (head != null) {
            // topRow -> leftCol to rightCol
            for (int j=leftCol; j<=rightCol && head!=null; j++) {
                matrix[topRow][j] = head.val;
                head = head.next;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for (int i=topRow; i<=bottomRow && head != null; i++) {
                matrix[i][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;

            // bottomRow -> rightCol to letfCol
            for (int j=rightCol; j>=leftCol && head!=null; j--) {
                matrix[bottomRow][j] = head.val;
                head = head.next;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i=bottomRow; i>=topRow && head!=null; i--) {
                matrix[i][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;

        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows (m): ");
        int m = sc.nextInt();
        System.out.println("Enter the number of columns (n): ");
        int n = sc.nextInt();

        // Create a linked list from user input
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Enter the elements of the linked list (end with -1): ");
        while (true) {
            int val = sc.nextInt();
            if (val == -1) break;
            list.insertAtTail(val);
        }

        SpiralMatrixIV spiralMatrixIV = new SpiralMatrixIV();
        int[][] result = spiralMatrixIV.spiralMatrix(m, n, list.head);

        System.out.println("The spiral matrix is: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
