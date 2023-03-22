package ProgrammingFundamentalsFinalExam02;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String input;

        while (!"Done".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            if (command.equals("TakeOdd")) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < word.length(); i += 2) {
                    builder.append(word.charAt(i));
                }
                word = builder.toString();
                System.out.println(word);


            }
            if (command.equals("Cut")) {
                int index = Integer.parseInt(commands[1]);
                int end = index + Integer.parseInt(commands[2]);
                word = new StringBuilder(word).delete(index, end).toString();
                System.out.println(word);

            }
            if (command.equals("Substitute")) {
                String substring = commands[1];
                String substitute = commands[2];
                if (word.contains(substring)) {
                    word = word.replace(substring, substitute);
                    System.out.println(word);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }


        }

        System.out.printf("Your password is: %s\n", word);
    }
}
