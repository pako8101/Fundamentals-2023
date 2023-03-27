package ProgrammingFundamentalsFinalExamRetake02;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String concealed = scanner.nextLine();
        String input;
        while (!"Reveal".equals(input = scanner.nextLine())) {
            String[] commands = input.split(":\\|:");
            String command = commands[0];
            if (command.equals("InsertSpace")) {
                int index = Integer.parseInt(commands[1]);
                StringBuilder builder = new StringBuilder(concealed);
                builder.insert(index, " ");
                concealed = builder.toString();
                System.out.println(concealed);
            } else if (command.equals("Reverse")) {
                String subs = commands[1];
                if (concealed.contains(subs)) {
                    String reversed = new StringBuilder(subs).reverse().toString();
//                    StringBuilder newBuild = new StringBuilder(concealed);
//                    newBuild.delete(newBuild.indexOf(subs),newBuild.indexOf(subs)+1);
//                    newBuild.insert(concealed.length()-1,reversed);
//                    concealed= newBuild.toString();
                    concealed = concealed.replace(subs, reversed);
                    System.out.println(concealed);
                } else {
                    System.out.println("error");
                }
            } else if (command.equals("ChangeAll")) {
                String substringChange = commands[1];
                String replacement = commands[2];
                concealed = concealed.replaceAll(substringChange, replacement);
                System.out.println(concealed);
            }

        }
        System.out.printf("You have a new text message: %s\n", concealed);
    }
}
