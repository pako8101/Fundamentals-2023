package ProgrammingFundamentalsWithJava2023.Lists.MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String text = scanner.nextLine();
        for (int number : numbersList) {
            int index = sumOfDigits(number) % text.length();
            char c = text.charAt(index);
            System.out.print(c);
            text = text.substring(0, index) + text.substring(index + 1);
        }
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;


    }
}

