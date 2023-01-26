package ProgrammingFundamentalsWithJava2023.Arrays.MoreExercise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());

        for (long i = 1; i <= n; i++) {
            long c = 1;
            for (long j = 1; j <= i; j++) {
                System.out.print(c + " ");
                c = c * (i - j) / j;
            }
            System.out.println();

        }

    }

}
