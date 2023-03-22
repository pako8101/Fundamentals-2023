package ProgrammingFundamentalsFinalExam02;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countBarcodes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countBarcodes; i++) {
            String input = scanner.nextLine();

            String regex = "^@#+(?=[A-Z])([A-Za-z0-9]{6,})(?<=[A-Z])@#+$"; //"(@#+)([A-Za-z0-9A-Z]{6,})(@#+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            String digit = "([\\d*])";

            if (!matcher.find()) {
                System.out.println("Invalid barcode");
            } else {
                String group = "";
                for (char j = 1; j <= input.length() - 1; j++) {
                    char c = input.charAt(j);
                    if (Character.isDigit(c)) {
                        group += c;
                    }
                }
                if (group.isEmpty()) {
                    group = "00";
                }
                System.out.printf("Product group: %s\n", group);
            }

        }
    }

}
