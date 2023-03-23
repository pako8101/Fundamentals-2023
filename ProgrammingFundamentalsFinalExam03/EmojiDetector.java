package ProgrammingFundamentalsFinalExam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> digitsList = new ArrayList<>();
        for (char symbol : input.toCharArray()) {
            if (Character.isDigit(symbol)) {
                int digit = Integer.parseInt(String.valueOf(symbol));
                digitsList.add(digit);
            }
        }
        long x = 1;
        for (Integer integer : digitsList) {
            x *= integer;
        }
        int count = 0;
        System.out.printf("Cool threshold: %s%n", x);
        List<String> listCalculations = new ArrayList<>();
        String regex = "(?<symbols>[:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String validEmoji = "";
        String[] tokens = input.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            Matcher matcher = pattern.matcher(tokens[i]);
            while (matcher.find()) {
                count++;
                validEmoji = matcher.group("name");
                int coolness = 0;
                for (int j = 0; j < validEmoji.length(); j++) {
                    char c = validEmoji.charAt(j);
                    if (Character.isLetter(c)) {
                        coolness += c;
                    }
                }
                if (coolness >= x) {
                    listCalculations.add(matcher.group(0));
                }

            }
        }
        System.out.printf("%d emojis found in the text. " +
                "The cool ones are:%n", count);
        for (String emoji : listCalculations) {
            emoji = emoji.replace("\\[\\]", "");
            System.out.println(emoji);

        }
    }


}
