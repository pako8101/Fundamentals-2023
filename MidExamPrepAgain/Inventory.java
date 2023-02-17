package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] commandArr = input.split(" - ");
            String command = commandArr[0];
            String item = commandArr[1];
            int index = inventory.indexOf(item);
            if (command.equals("Collect")) {
                if (!inventory.contains(item)) {
                    inventory.add(item);
                }
            } else if (command.equals("Drop")) {
                if (inventory.contains(item)) {
                    inventory.remove(item);
                }
            } else if (command.equals("Combine Items")) {
                String[] combineArr = commandArr[1].split(":");
                String oldItem = combineArr[0];
                String newItem = combineArr[1];
                int indexOfOld = inventory.indexOf(oldItem);
                inventory.add(indexOfOld + 1, newItem);
            } else if (command.equals("Renew")) {
                if (inventory.contains(item)) {
                    inventory.remove(item);
                    inventory.add(item);
                }

            }
            input = scanner.nextLine();

        }
        System.out.println(String.join(", ", inventory));

    }

}

