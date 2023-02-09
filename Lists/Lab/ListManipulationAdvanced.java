package ProgrammingFundamentalsWithJava2023.Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];
            if (command.equals("Contains")) {
                int number = Integer.parseInt(commandArr[1]);
                if (numbers.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            }
            if (command.equals("Print")) {
                String evenCommand = commandArr[1];
                if (evenCommand.equals("even")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        int even = numbers.get(i);
                        if (even % 2 == 0) {
                            System.out.printf("%d ", even);
                        }
                    }
                } else if (evenCommand.equals("odd")) {
                    System.out.println();
                    for (int i = 0; i < numbers.size(); i++) {
                        int odd = numbers.get(i);
                        if (odd % 2 == 1) {
                            System.out.print(odd + " ");
                        }
                    }
                    System.out.println();
                }
            } else if (command.equals("Get")) {
                String secondCommand = commandArr[1];
                if (secondCommand.equals("sum")) {
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        int num = numbers.get(i);
                        sum += num;
                    }
                    System.out.println(sum);
                }

            } else if (command.equals("Filter")) {
                String condition = commandArr[1];
                int number = Integer.parseInt(commandArr[2]);
                for (int i = 0; i < numbers.size(); i++) {
                    int num = numbers.get(i);
                    if (condition.equals("<")) {
                        if (num < number) {
                            System.out.printf("%d", num);
                        }
                    } else if (condition.equals(">")) {
                        if (num > number) {
                            System.out.printf("%d", num);
                        }
                        System.out.println();
                    } else if (condition.equals(">=")) {
                        if (num >= number) {
                            System.out.printf("%d", num);
                        }

                    } else if (condition.equals("<=")) {
                        if (num <= number) {
                            System.out.printf("%d", num);
                        }
                        System.out.println();
                    }
                }
            }
            input = scanner.nextLine();
        }
    }
}
