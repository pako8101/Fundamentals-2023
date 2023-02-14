package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPreparation13February2023;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals("end")) {
            count++;
            String[] tokens = input.split("\\s+");
            int index1 = Integer.parseInt(tokens[0]);
            int index2 = Integer.parseInt(tokens[1]);
            if (cheat(index1, index2, elements)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                elements.add(elements.size() / 2, String.format("-%da", count));
                elements.add(elements.size() / 2, String.format("-%da", count));
            } else {
                String first = elements.get(index1);
                String second = elements.get(index2);
                if (first.equals(second)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n!", first);
                    elements.remove(first);
                    elements.remove(second);
                } else {
                    System.out.println("Try again!");
                }
            }
            if (elements.isEmpty()) {
                break;
            }

            input = scanner.nextLine();
        }
        if (elements.isEmpty()){
            System.out.printf("You have won in %d turns!%n", count);
        }else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", elements));
        }
    }

    public static boolean cheat(int index1, int index2, List<String> elements) {
        if (index1 == index2 && isInvalidIndex(index1, elements) ||
                isInvalidIndex(index2, elements)) {
            return true;
        }
        return false;
    }


    public static boolean isInvalidIndex(int index, List<String> elements) {
        if (index < 0 || index >= elements.size()) {
            return true;
        }
        return false;
    }
}
