package ProgrammingFundamentalsWithJava2023.Methods.MoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        dataTypes(input, scanner);

    }
    public static void dataTypes(String input, Scanner scanner) {
        if (input.equals("int")) {
            int num = Integer.parseInt(scanner.nextLine());
            System.out.println(num * 2);
        } else if (input.equals("real")) {
            double real = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f", real * 1.5);
        } else if (input.equals("string")) {
            String word = scanner.nextLine();
            System.out.println("$" + word + "$");
        }
    }

}
