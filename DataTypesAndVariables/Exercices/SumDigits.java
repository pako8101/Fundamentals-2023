package DataTypesAndVariables.Exercices;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());
        long original = number;
        long sum = 0;

        while (original != 0) {
            long last = original % 10;
            sum += last;
            original /= 10;

        }
        System.out.println(sum);


    }
}
