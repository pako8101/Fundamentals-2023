package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPreparation13February2023;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int currentCount = 0;
        String input = scanner.nextLine();
        while (!input.equals("End of battle")) {
            int distanceEnemy = Integer.parseInt(input);
            if (energy < distanceEnemy) {
                System.out.printf("Not enough energy! Game ends with " +
                        "%d won battles and %d energy%n", count, energy);
                return;
            }
            // for (int i = 0; i < distanceEnemy; i++) {
            energy -= distanceEnemy;
            count++;
            if (count % 3 == 0) {
                energy += count;

            }

            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d%n", count, energy);

    }
}
