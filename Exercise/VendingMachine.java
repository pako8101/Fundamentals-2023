package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Start")){
                break;
            }
            double coins = Double.parseDouble(input);
            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f%n", coins);
            } else {
                sum += coins;

            }
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }
            double price = -1;
            if (input.equals("Nuts")) {
                price = 2.0;
            } else if (input.equals("Water")) {
                price = 0.7;
            } else if (input.equals("Crisps")) {
                price = 1.5;
            } else if (input.equals("Soda")) {
                price = 0.8;
            } else if (input.equals("Coke")) {
                price = 1.0;
            }
            if (price == -1) {
                System.out.println("Invalid product");
            } else if (sum < price) {
                System.out.println("Sorry, not enough money");
            } else {
                System.out.println("Purchased " + input);

                sum -= price;
            }
        }
            System.out.printf("Change: %.2f%n", sum );
        }
    }
