package DataTypesAndVariables.Exercices;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int sum = 0;

        for (int i = 1; i <= lines; i++) {
            int litters = Integer.parseInt(scanner.nextLine());

            if (sum + litters >capacity) {
                System.out.println("Insufficient capacity!");

            }else {
                sum+=litters;
            }
        }System.out.println(sum);
    }
}