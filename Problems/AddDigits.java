package LinkedList.Problems;

import java.util.Scanner;

public class AddDigits {
    static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int slow = num;
        int fast = getNext(num);
        while (fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow;
    }

    static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(addDigits(n));
        }
        sc.close();
    }
}
