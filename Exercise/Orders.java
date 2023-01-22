package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfOrders = Integer.parseInt(scanner.nextLine());
        double orderPrice = 0.0;
        double total = 0.0;
        for (int i = 1; i <= countOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            orderPrice = (pricePerCapsule * days) * capsulesCount;

            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);
            total += orderPrice;
        }


        System.out.printf("Total: $%.2f%n", total);
    }

}

