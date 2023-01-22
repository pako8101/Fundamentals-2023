package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = Long.parseLong(scanner.nextLine());
        long original = num;

        long sum = 0;
        while (original != 0) {
            long last = original % 10;
            original /= 10;
            long fact = 1;
            for (int i = 1; i <= last; i++) {
                fact *= i;
            }
            sum += fact;

        }
        if (sum == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

}