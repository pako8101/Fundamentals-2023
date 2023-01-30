package ProgrammingFundamentalsWithJava2023.Methods.Excercise.Again;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        sum(num1, num2, num3);

    }


    public static void sum(int num1, int num2, int num3) {
        int sum = (num1 + num2) - num3;
        System.out.println(sum);

    }
}
