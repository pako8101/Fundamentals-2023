package ProgrammingFundamentalsWithJava2023.Methods.Excercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        printChar(symbol1, symbol2);

    }

    public static void printChar(char a, char b) {
        if (a < b) {
            for (char i = (char) (a + 1); i < b; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (b + 1); i < a; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
