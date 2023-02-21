package ProgrammingFundamentalsFinalExamRetake01;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMess = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commands = input.split("\\|");
            String command = commands[0];
            if (command.equals("Move")) {
                int letterNumber = Integer.parseInt(commands[1]);
                StringBuilder builder = new StringBuilder(encryptedMess);
                for (int i = 0; i < letterNumber; i++) {
                    builder.append(builder.charAt(0));
                    builder.deleteCharAt(0);
                }
              encryptedMess= builder.toString();
               /* String first = encryptedMess.substring(0,letterNumber);
                String second = encryptedMess.substring(letterNumber);
                encryptedMess=second.concat(first);*/
            }
            if (command.equals("Insert")) {
                String value = commands[2];
                int index = Integer.parseInt(commands[1]);
                if (index>=0 && index<=encryptedMess.length()) {
                    StringBuilder strBuilder = new StringBuilder(encryptedMess);
                    strBuilder.insert(index, value);
                    encryptedMess = strBuilder.toString();
                   /* String first = encryptedMess.substring(0,index);
                    String second = encryptedMess.substring(index);
                    encryptedMess=first.concat(value).concat(second);*/
                }
            } if (command.equals("ChangeAll")) {
                 String substring = commands[1];
                String replacement = commands[2];
                encryptedMess=encryptedMess.replace(substring,replacement);

            }
            input = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + encryptedMess);
    }
}
