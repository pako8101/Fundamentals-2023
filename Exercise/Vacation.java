package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double totalPrice = 0.0;
        if (group.equals("Students")) {
            if (day.equals("Friday")) {
                price = 8.45;
            } else if (day.equals("Saturday")) {
                price = 9.80;
            } else if (day.equals("Sunday")) {
                price = 10.46;
            }
            totalPrice = price * count;
            if (count >= 30) {
                totalPrice *= 0.85;
            }
        } else if (group.equals("Business")) {
            if (day.equals("Friday")) {
                price = 10.90;
            } else if (day.equals("Saturday")) {
                price = 15.60;
            } else if (day.equals("Sunday")) {
                price = 16;
            }
            totalPrice = price * count;
            if (count >= 100) {
                totalPrice *= 0.90;
            }
        } else if (group.equals("Regular")) {
            if (day.equals("Friday")) {
                price = 15;
            } else if (day.equals("Saturday")) {
                price = 20;
            } else if (day.equals("Sunday")) {
                price = 22.50;
            }
            totalPrice = price * count;
            if (count >= 10 && count <= 20) {
                totalPrice *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}