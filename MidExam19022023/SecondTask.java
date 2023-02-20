package ProgrammingFundamentalsWithJava2023.MidExam19022023;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] travelRoute = scanner.nextLine().split("\\|\\|");
        int startFuel = Integer.parseInt(scanner.nextLine());
        int ammoStart = Integer.parseInt(scanner.nextLine());
        for (String commands : travelRoute) {
            String[] parts = commands.trim().split("\\s+");
            String command = parts[0];
            while (!command.equals("Titan")) {
                if (command.equals("Travel")) {
                    int number = Integer.parseInt(parts[1]);
                    if (startFuel >= number) {
                        startFuel -= number;
                        System.out.printf("The spaceship travelled %d light-years%n", number);
                    } else {
                        System.out.println("Mission failed");
                        return;
                    }
                } else if (command.equals("Enemy")) {
                    int enemyArmour = Integer.parseInt(parts[1]);
                    if (enemyArmour <= ammoStart) {
                        ammoStart -= enemyArmour;
                        System.out.printf("An enemy with %d armour is defeated.%n", enemyArmour);
                    } else if (startFuel >= enemyArmour * 2) {
                        startFuel -= enemyArmour * 2;

                        System.out.printf("An enemy with %d armour is outmaneuvered.%n", enemyArmour);
                    } else {
                        System.out.println("Mission failed");
                        return;
                    }
                } else if (command.equals("Repair")) {
                    int ammoAndFuel = Integer.parseInt(parts[1]);
                    startFuel += ammoAndFuel;
                    ammoStart += ammoAndFuel * 2;
                    System.out.printf("Ammunitions added: %d%n", ammoAndFuel);
                    System.out.printf("Fuel added: %d%n", ammoAndFuel);

                }
                command = scanner.nextLine();

                System.out.println("You have reached Titan, all passengers are safe");
            }

        }
    }
}




