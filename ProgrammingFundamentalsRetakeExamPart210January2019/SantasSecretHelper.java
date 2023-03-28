package ProgrammingFundamentalsRetakeExamPart210January2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String regex = "([@])(?<name>[A-Za-z]+)[^@\\-!:>]*([!])(?<behavior>[G])([!])";
        Pattern pattern = Pattern.compile(regex);
        String input;
        String name = "";
        while (!"end".equals(input = scanner.nextLine())) {
           /* Function<String, Integer> parser = e-> Integer.parseInt(e);
            Function<Integer,Integer> subtract = e-> e/key;
            String[] arrInput = input.split("");
           List<String> list =  Arrays.stream(arrInput)
                    .map(parser)
                    .map(subtract)
                   .map(e-> e.toString())
                    .collect(Collectors.toList());
            for (String newName: list) {*/
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char symbol = (char) (input.charAt(i) - key);
                decrypted.append(symbol);

            }
            Matcher matcher = pattern.matcher(decrypted.toString());
            if (matcher.find()) {
                name = matcher.group("name");
                System.out.println(name);


            }


        }
    }
}