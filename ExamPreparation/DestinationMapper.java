package ProgrammingFundamentalsWithJava2023.ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String places = scanner.nextLine();
        String regex = "([=|\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);
        int travelPoints = 0;
        List<String> validDestinations = new ArrayList<>();
        while (matcher.find()){
            String destination = matcher.group("destination");
            travelPoints = travelPoints + destination.length();
            validDestinations.add(destination);
        }
        System.out.println("Destinations: ");
        System.out.println(String.join(",", validDestinations));
        System.out.printf("Travel points:%d%n", travelPoints);
    }
}
