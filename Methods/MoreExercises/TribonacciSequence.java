package ProgrammingFundamentalsWithJava2023.Methods.MoreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        calculateNumbersTribonacci(num);
    }

    public static void calculateNumbersTribonacci(int num) {
        int a = 1, b = 1, c = 1;

        for (int i = 1; i <= num; i++) {
                System.out.println(a);
                int d = a + b + c;
              a=b;
              b=c;
              c=d;
            }
        }
    }
