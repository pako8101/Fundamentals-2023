package ProgrammingFundamentalsWithJava2023.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int index = 0; index < numbers.length; index++) {
            int current = numbers[index];
            boolean isBigger = true;
            for (int rightIndex = index + 1; rightIndex < numbers.length; rightIndex++) {
                if (numbers[index] < numbers[rightIndex]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(numbers[index] + " ");

            }
        }

    }
}