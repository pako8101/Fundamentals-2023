package ProgrammingFundamentalsWithJava2023.Methods.Excercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while (!number.equals("END")) {
            reversed(number);
            System.out.println(reversed(number));

            number = scanner.nextLine();

        }
    }
    public static boolean reversed(String number) {
        String reverse = new StringBuilder(number).reverse().toString();
        return  number.equals(reverse);
        /*String output = "";
        String reversed = " ";
        for (int i = number.length() - 1; i >= 0; i--) {
            reversed += number.charAt(i);
        }
        if (reversed.equals(number)) {
            output = "true";
        } else {

            output = "false";
        }
        return output;*/
    }
}
