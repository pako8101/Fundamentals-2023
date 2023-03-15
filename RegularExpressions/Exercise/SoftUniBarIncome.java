package ProgrammingFundamentalsWithJava2023.RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double incomes = 0;
        String regex = "%(?<costumer>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+){1}\\|[^|$%.]*?(?<price>\\d+\\.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);//шаблон

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String costumer = matcher.group("costumer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = count * price;
                incomes += totalPrice;

                System.out.printf("%s: %s - %.2f\n", costumer, product, totalPrice);

            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f\n", incomes);

    }


}


