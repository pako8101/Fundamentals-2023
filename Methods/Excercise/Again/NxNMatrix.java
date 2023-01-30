package ProgrammingFundamentalsWithJava2023.Methods.Excercise.Again;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Nxn(num);
    }

    private static void Nxn(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
