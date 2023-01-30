package ProgrammingFundamentalsWithJava2023.Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        switch (product) {
            case "coffee":
                coffee(quantity);
                break;
            case "water":
                water(quantity);
                break;
            case "coke":
                coke(quantity);
                break;
            case "snacks":
                snacks(quantity);
                break;
        }


    }

    public static void coffee(int quantity) {
        double result = quantity * 1.50;
        System.out.printf("%.2f",result);

    }

    public static void water(int quantity) {
        double result = quantity * 1.00;
        System.out.printf("%.2f",result);
    }
    public static void coke(int quantity) {
        double result = quantity * 1.40;
        System.out.printf("%.2f",result);
    }
    public static void snacks(int quantity) {
        double result = quantity * 2.00;
        System.out.printf("%.2f",result);
    }
}