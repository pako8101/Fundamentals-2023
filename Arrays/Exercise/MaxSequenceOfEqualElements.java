package ProgrammingFundamentalsWithJava2023.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int counter = 1;
        int maxCounter = 0;
        int element = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] == arr[i - 1]) {
                counter++;

                if (counter > maxCounter) {
                    maxCounter = counter;
                    element = arr[i];
                }
            } else
                counter = 1;
            }

            for (int j = 0; j < maxCounter; j++) {
                System.out.print(element + " ");

                }
            }
        }


