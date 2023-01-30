package ProgrammingFundamentalsWithJava2023.Methods.Excercise.Again;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        long fact1 = factorial(num1);
        long fact2 = factorial(num2);

        double result = fact1 * 1.0 / fact2;
        System.out.printf("%.2f", result);

    }

    public static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
