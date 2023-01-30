package ProgrammingFundamentalsWithJava2023.Methods.Excercise.Again;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        while (!number.equals("END")) {
            palindromeOrNot(number);
            System.out.println(palindromeOrNot(number));

            number = scanner.nextLine();
        }
    }

    public static String palindromeOrNot(String num) {
        String reversed = "";
        String output = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            reversed += num.charAt(i);
        }
            if (reversed.equals(num)) {
                output = "true";
            } else {
                output = "false";
            }
            return output;
        }
    }
