package FundametalFinalExam02042023;

import java.util.Scanner;

public class TaskFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Translate":
                    char replace = command[1].charAt(0);
                    String replacement = command[2];
                    str = str.replace(replace, replacement.charAt(0));
                    System.out.println(str);
                    break;
                case "Includes":
                    String subs = command[1];
                    if (str.contains(subs)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String substring = command[1];
                    if (str.startsWith(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    str = str.toLowerCase();
                    System.out.println(str);
                    break;
                case "FindIndex":
                    char charToFind = command[1].charAt(0);
                    int last = str.lastIndexOf(charToFind);
                    System.out.println(last);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
                    str = str.substring(0, startIndex) + str.substring(startIndex + count);
                    System.out.println(str);
                    break;

            }

            input= scanner.nextLine();

        }

    }

}
