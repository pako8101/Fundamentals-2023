package ProgrammingFundamentalsWithJava2023.Methods.Excercise.Again;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n ; i++) {
        if (sumOfDivisible(i) && sumOfOdd(i)) {
            System.out.println(i);
        }
        }

    }

    private static boolean sumOfOdd(int num) {

        while (num > 0) {
            int last = num % 10;
            if (last % 2 == 1) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }
        public static boolean sumOfDivisible ( int num){
            int sum = 0;
            while (num > 0) {
                int last = num % 10;
                sum += last;
                num = num / 10;

            }
            return sum % 8 == 0;
        }
    }
