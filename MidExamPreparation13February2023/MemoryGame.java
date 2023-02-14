package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPreparation13February2023;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbersListTwins = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int moves = 0;
        while (!input.equals("end")) {
            moves++;
            String[] numbers = input.split(" ");
            int index1 = Integer.parseInt(numbers[0]);
            int index2 = Integer.parseInt(numbers[1]);
            if (!isValidIndex(numbersListTwins, index1,
                    index2) || index1 == index2) {
                int middle = numbersListTwins.size() / 2;
                numbersListTwins.add(middle, "-" + moves + "a");
                numbersListTwins.add(middle, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (numbersListTwins.get(index1).equals(numbersListTwins.get(index2))) {
                String indexValue = numbersListTwins.get(index1);
                if (index1 > index2) {
                    numbersListTwins.remove(index1);
                    numbersListTwins.remove(index2);
                } else {
                    numbersListTwins.remove(index2);
                    numbersListTwins.remove(index1);
                }
                System.out.printf("Congrats! You have found matching elements - %s!%n", indexValue);
            } else if (!numbersListTwins.get(index1).equals(numbersListTwins.get(index2))) {
                System.out.println("Try again!");
            }
            if (numbersListTwins.isEmpty()) {
                System.out.printf("You have won in %d turns!", moves);
                return;
            }

            input = scanner.nextLine();
        }
        System.out.println("Sorry you lose :(" );
        for (String item : numbersListTwins) {

            System.out.printf(item + " ");

        }
    }

    private static boolean isValidIndex(List<String> numbers, int index1, int index2) {
        return index1 >= 0 && index1 < numbers.size() &&
                index2 >= 0 && index2 < numbers.size();
    }

    private static boolean matchingElements(List<Integer> numbers, int index1, int index2) {
        boolean match = true;
        for (int item : numbers) {
            match = item == index1 && item == index2;

        }
        return match;
    }
}