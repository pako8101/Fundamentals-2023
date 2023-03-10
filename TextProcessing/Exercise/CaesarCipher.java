package ProgrammingFundamentalsWithJava2023.TextProcessing.Exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (char position:text.toCharArray()) {
            char encryptedSymbol = (char)(position + 3);
            encryptedText.append(encryptedSymbol);
        }
        System.out.println(encryptedText);
    }
}
