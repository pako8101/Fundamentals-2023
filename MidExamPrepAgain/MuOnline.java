package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;
        int bestRoom = 0;
        for (int i = 0; i < rooms.length; i++) {
            String[] room = rooms[i].split("\\s+");
            String command = room[0];
            int number = Integer.parseInt(room[1]);
            if (command.equals("potion")) {
                bestRoom++;
                int currentHealth = health + number;
                if (currentHealth < 100) {
                    health += number;
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.\n", currentHealth);
                } else {
                    int potionHealing = (100 + number) - currentHealth;
                    health += potionHealing;
                    System.out.printf("You healed for %d hp.%n", potionHealing);
                    System.out.printf("Current health: %d hp.\n", health);
                }


            } else if (command.equals("chest")) {
                bestRoom++;
                int numberOfBitcoins = Integer.parseInt(room[1]);
                System.out.printf("You found %d bitcoins.%n", numberOfBitcoins);
                bitcoins += numberOfBitcoins;
            } else {
                bestRoom++;
                String monster = room[0];
                int attack = Integer.parseInt(room[1]);
                health -= attack;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", monster);
                } else {
                    System.out.printf("You died! Killed by %s.\n", monster);

                    System.out.printf("Best room: %d\n", bestRoom);
                    return;
                }
            }

        }
        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n", bitcoins);
            System.out.printf("Health: %d\n", health);

        }
    }
}
