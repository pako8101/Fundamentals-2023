package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String command1 = input.split(" ")[0];
            int command2 = Integer.parseInt(input.split(" ")[1]);
            if (command1.equals("Delete")) {
                numbersList.removeAll(Arrays.asList(command2));
                    } else if (command1.equals("Insert")) {
                        int numberToInsert2 = Integer.parseInt(input.split(" ")[2]);
                        numbersList.add(numberToInsert2, command2);

                    }
                    input = scanner.nextLine();
                }
                for (int item:numbersList
                     ) {
                    System.out.println(item + " ");
                }
            }
        }


