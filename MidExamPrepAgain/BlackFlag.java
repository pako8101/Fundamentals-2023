package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double total = 0;
        for (int i = 1; i <= days; i++) {
            total += dailyPlunder;
            if (i % 3 == 0) {
                total += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                total *= 0.7;
            }
        }

        if (total >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", total);
        } else {
            double percent = (total / expectedPlunder) * 100;

            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}