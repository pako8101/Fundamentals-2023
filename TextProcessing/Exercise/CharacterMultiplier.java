package ProgrammingFundamentalsWithJava2023.TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrStrings = scanner.nextLine().split(" ");
        String one = arrStrings[0];
        String two = arrStrings[1];
        System.out.println(CharacterMultiply(one,two));

    }

    public static long CharacterMultiply(String first, String second) {
        char[] one = first.toCharArray();
        char[] two = second.toCharArray();
        long sum = 0;
        long tempSum = 0;
        int shortWord = Math.min(one.length, two.length);
        int longestWord = Math.max(one.length, two.length);

        for (int i = 0; i < shortWord; i++) {
            tempSum = (int) one[i] * (int) two[i];
            sum += tempSum;
        }
        if (one.length < two.length) {
            for (int i = shortWord; i <= longestWord - 1; i++) {
                sum += two[i];
            }
        } else if (one.length > two.length) {
            for (int i = shortWord; i <= longestWord - 1; i++) {
                sum += one[i];
            }

        }return sum;
    }
}
