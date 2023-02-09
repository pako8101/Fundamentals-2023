package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get initial list of integers
        String[] input = scanner.nextLine().split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String num : input) {
            numbers.add(Integer.parseInt(num));
        }

        // Continuously read and perform commands
        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("End")) {
                break;
            } else if (command[0].equals("Add")) {
                numbers.add(Integer.parseInt(command[1]));
            } else if (command[0].equals("Insert")) {
                int index = Integer.parseInt(command[2]);
                if (index < 0 || index > numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index, Integer.parseInt(command[1]));
                }
            } else if (command[0].equals("Remove")) {
                int index = Integer.parseInt(command[1]);
                if (index < 0 || index >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }
            } else if (command[0].equals("Shift")) {
                int count = Integer.parseInt(command[2]);
                if (count < 0) {
                    System.out.println("Invalid count");
                } else if (command[1].equals("left")) {
                    for (int i = 0; i < count; i++) {
                        numbers.add(numbers.remove(0));
                    }
                } else if (command[1].equals("right")) {
                    for (int i = 0; i < count; i++) {
                        numbers.add(0, numbers.remove(numbers.size() - 1));
                    }
                }
            }
        }

        // Print the final list of integers
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}







