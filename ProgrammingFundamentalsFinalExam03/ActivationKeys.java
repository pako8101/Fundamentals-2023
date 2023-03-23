package ProgrammingFundamentalsFinalExam03;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String[] instructions = input.split(">>>");
            String command = instructions[0];
            if (command.equals("Contains")) {
                String substring = instructions[1];
                if (activationKey.contains(substring)) {
                    System.out.printf("%s contains %s", activationKey, substring);
                } else {
                    System.out.println("Substring not found!");
                }
            }
            if (command.equals("Flip")) {
                String command2 = instructions[1];
                int startIndex = Integer.parseInt(instructions[2]);
                int endIndex = Integer.parseInt(instructions[3]);
                if (command2.equals("Upper")) {
                    String toReplace = activationKey.substring(startIndex, endIndex);
                    String replacement = activationKey.substring(startIndex, endIndex);
                    activationKey = activationKey.replace(toReplace, replacement.toUpperCase());
                    System.out.println(activationKey);
                } else if (command2.equals("Lower")) {
                    String toReplace = activationKey.substring(startIndex, endIndex);
                    String replacement = activationKey.substring(startIndex, endIndex);
                    activationKey = activationKey.replace(toReplace, replacement.toLowerCase());
                    System.out.println(activationKey);
                }

            }
            if (command.equals("Slice")) {
                StringBuilder builder = new StringBuilder(activationKey);
                int startIndex = Integer.parseInt(instructions[1]);
                int endIndex = Integer.parseInt(instructions[2]);
                // if (isValidIndex(activationKey,startIndex)&&isValidIndex(activationKey,endIndex)){
                builder.delete(startIndex, endIndex);
                activationKey = builder.toString();
                System.out.println(activationKey);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }

    private static boolean isValidIndex(String string, int targetIndex) {
        return targetIndex >= 0 && targetIndex < string.length();
    }
}
