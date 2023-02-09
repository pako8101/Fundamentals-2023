package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arrStrings = input.split("\\s+");
            String command = arrStrings[0];
            switch (command) {
                case "Add":
                    int addNum = Integer.parseInt(arrStrings[1]);
                    numbersList.add(addNum);
                    break;
                case "Insert":
                    int insertNum = Integer.parseInt(arrStrings[1]);
                    int insertAtIndex = Integer.parseInt(arrStrings[2]);
                    if (insertAtIndex<0 || insertAtIndex>numbersList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numbersList.add(insertAtIndex, insertNum);
                    }
                    break;
                case "Remove":
                    int removeNum = Integer.parseInt(arrStrings[1]);
                    if (removeNum<0|| removeNum>=numbersList.size()) {
                        System.out.println("Invalid index");
                    } else {

                        numbersList.remove(removeNum);
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(arrStrings[2]);
                    String position = arrStrings[1];
                    if (position.equals("left")) {
                        for (int time = 0; time < count; time++) {
                            int firstNum = numbersList.get(0);
                            numbersList.remove(0);
                            //numbersList.set(numbersList.size() - 1, firstNum);
                            numbersList.add(firstNum);
                        }
                    }
                    if (position.equals("right")) {
                        for (int time = 0; time < count; time++) {
                            int lastNum = numbersList.get(numbersList.size()) - 1;
                            numbersList.remove(numbersList.size() - 1);
                            numbersList.add(0, lastNum);
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        for (Integer item : numbersList) {
            System.out.print(item + " ");

        }

    }

    public static boolean isValidIndex(int index, List<Integer> numbers) {
        return index >= 0 && index <= numbers.size() - 1;

    }
}
