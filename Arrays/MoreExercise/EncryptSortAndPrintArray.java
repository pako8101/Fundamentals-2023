package ProgrammingFundamentalsWithJava2023.Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        int lines = 0;
        while (lines != n) {
            String word = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < word.length(); j++) {
                int wordAsInt = (int) word.charAt(j);
                char charValidator = Character.toLowerCase(word.charAt(j));
                if (charValidator == 'a' || charValidator == 'o'
                        || charValidator == 'e' || charValidator == 'i' || charValidator == 'u') {
                    wordAsInt *= word.length();
                    sum += wordAsInt;

                } else {
                    wordAsInt /= word.length();
                    sum += wordAsInt;
                }
            }
                arr[lines] = sum;
                lines++;
            }
            Arrays.sort(arr);
            for (int number : arr) {
                System.out.println(number);
            }
        }
    }

