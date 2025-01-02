package LinkedList.Problems;

import java.util.Scanner;

public class HappyNumber {
    static HappyNumber obj = new HappyNumber();

    boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        do {
            slow = obj.square(slow);
            fast = obj.square(obj.square(fast));
        } while (slow != fast);

        return slow == 1;
    }

    int square(int num) {
        int ans = 0;
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            // System.out.println(obj.square(n));
            System.out.println(obj.isHappy(n));
        }
        sc.close();
    }
}
