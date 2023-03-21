package ProgrammingFundamentalsFinalExam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String places = scanner.nextLine();
        String regex = "([=|\\/])(?<word1>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);
        List<String> destinations = new ArrayList<>();
        int points= 0;
        if (matcher.find()) {
            String destination = matcher.group("word1");
            points+= destination.length();
            destinations.add(destination);
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.printf("Travel points:%d%n", points);
    }
}
