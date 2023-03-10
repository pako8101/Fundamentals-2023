package ProgrammingFundamentalsWithJava2023.TextProcessing.MoreExercises;

import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int[] numbers = new int[num.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = num.charAt(i) - 'O';
        }
        String command = scanner.nextLine();

        while (!command.equals("find")) {
            StringBuilder decrypted = new StringBuilder();

            for (int charachter = 0; charachter < command.length(); charachter++) {
                int keyIndex = charachter % numbers.length;
                char decryptedChar = (char) (command.charAt(charachter) - numbers[keyIndex]);
                decrypted.append(decryptedChar);
            }
            int type = command.indexOf("&");
            int coordinatesStart = decrypted.indexOf("<");
            int coordinatesEnd = decrypted.indexOf(">");
            String treasureType = decrypted.substring(type + 1, coordinatesEnd);
            String coordinates = decrypted.substring(coordinatesEnd + 1);
            System.out.println("Found" + treasureType + "at" + coordinates);
            command = scanner.nextLine();
        }

    }
}

