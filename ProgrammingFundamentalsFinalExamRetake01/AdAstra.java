package ProgrammingFundamentalsFinalExamRetake01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String food = scanner.nextLine();
        int count = 0;
        String regex = "(?<symbols>[#\\|])(?<first>[A-za-z\\s]+)(\\1)(?<date>[0-9]{2}[\\/][0-9]{2}[\\/][0-9]{2})(\\1)(?<calories>[\\d]{1,5})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(food);

        List<String> foods = new ArrayList<>();

        while (matcher.find()) {
            String product = matcher.group("first");
            String date = matcher.group("date");
            int calorie = Integer.parseInt(matcher.group("calories"));

            count += calorie;
            foods.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", product, date, calorie));

        }
        System.out.printf("You have food to last you for: %d days!%n", count / 2000);

        foods.forEach(System.out::print);

    }
}