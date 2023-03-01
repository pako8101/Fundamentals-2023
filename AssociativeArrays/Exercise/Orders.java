package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String input = scanner.nextLine();

        Map<String, Double> orders = new LinkedHashMap<>();
        Map<String, Integer> quantities = new LinkedHashMap<>();
        int sum = 0;
        while (!input.equals("buy")) {
            String[] products = input.split(" ");
            String name = products[0];
            double price = Double.parseDouble(products[1]);
            int quantity = Integer.parseInt(products[2]);

            if (!orders.containsKey(name)) {
                orders.put(name, price);
                quantities.put(name, quantity);
            } else {
                orders.replace(name, price);
                quantities.replace(name, quantities.get(name) + quantity);
            }
            input = scanner.nextLine();
        }

        for (String item : orders.keySet()) {
            double total = orders.get(item) * quantities.get(item);
            System.out.printf("%s -> %.2f%n", item, total);
        }

    }
}
