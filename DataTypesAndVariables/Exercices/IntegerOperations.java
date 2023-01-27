package DataTypesAndVariables.Exercices;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = Long.parseLong(scanner.nextLine());
        long num2 = Long.parseLong(scanner.nextLine());
        long num3 = Long.parseLong(scanner.nextLine());
        long num4 = Long.parseLong(scanner.nextLine());
        long result = 0;
        result = ((num1+num2)/num3) * num4;
        System.out.println(result);

    }
}
