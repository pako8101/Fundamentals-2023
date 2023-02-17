package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] arrStrings = command.split(" ");
            if (arrStrings[0].equals("swap")) {
                int index1 = Integer.parseInt(arrStrings[1]);
                int index2 = Integer.parseInt(arrStrings[2]);
                int swap1 = num[index1];
                int swap2 = num[index2];
                num[index1] = swap2;
                num[index2] = swap1;
            } else if (arrStrings[0].equals("multiply")) {
                int index1 = Integer.parseInt(arrStrings[1]);
                int index2 = Integer.parseInt(arrStrings[2]);
                int multiplyNum = num[index1] * num[index2];
                num[index1] = multiplyNum;
            } else if (arrStrings[0].equals("decrease")) {
                for (int i = 0; i < num.length; i++) {
                    num[i] -= 1;
                }

            }
            command = scanner.nextLine();
        }
        for (int item : num) {
            if (item == num[0]) {
                System.out.print(item);
            } else {
                System.out.print(", " + item);
            }
        }
    }
}

