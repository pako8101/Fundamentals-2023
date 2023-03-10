package ProgrammingFundamentalsWithJava2023.TextProcessing.MoreExercises;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int startName = input.indexOf("@");
            int endName = input.indexOf("|");
            String name = input.substring(startName + 1, endName);

            int ageStart = input.indexOf("#");
            int ageEnd = input.indexOf("*");
            int age = Integer.parseInt(input.substring(ageStart + 1, ageEnd));

            System.out.println(name +" is " + age + "years old.");

        }
        System.out.println();

    }
}
