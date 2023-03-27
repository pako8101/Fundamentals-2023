package ProgrammingFundamentalsFinalExamRetake02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> mirror = new ArrayList<>();
        String regex = "([@#])(?<one>[A-Za-z]{3,}+)\\1\\1(?<two>[A-Za-z]{3,}+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;

            String first = matcher.group("one");
            String second = matcher.group("two");
            String reversed2 = new StringBuilder(second).reverse().toString();
            if (first.equals(reversed2)) {
                mirror.add(first + " <=> " + second);
            }
        }
        if (count > 0) {
            System.out.printf("%d word pairs found!\n", count);
        } else {
            System.out.println("No word pairs found!");
        }
        if (mirror.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirror));
        }
    }
}
