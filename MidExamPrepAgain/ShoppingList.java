package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine()
                        .split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split(" ");
            String command = commands[0];
            String item = commands[1];
            if (command.equals("Urgent")) {
                if (!text.contains(item)) {
                    text.remove(item);
                    text.set(0, item);
                }

            } else if (command.equals("Unnecessary")) {
                if (text.contains(item)) {
                    text.remove(item);
                }
            } else if (command.equals("Correct")) {
                String newItem = commands[2];
                int old = text.indexOf(item);
                if (text.contains(item)) {
                    text.set(old, newItem);
                    text.remove(item);
                }
            } else if (command.equals("Rearrange")) {
                if (text.contains(item)) {
                    text.remove(item);
                    text.add(item);
                }
                /*List<Double> grades = new ArrayList<>(Arrays.asList(5.6, 6.7));
                grades.removeAll(Arrays.asList(6.7));
                Collections.reverse(grades);*/
            }

            input = scanner.nextLine();
        }
       /* for (String item : text) {
            if (item.equals(text.get(text.size()-1))) {
                System.out.print(item);
            } else {
                System.out.print(item + ",");*/
        System.out.println(String.join(", ", text));
    }
}

