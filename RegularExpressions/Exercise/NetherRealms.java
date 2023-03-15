package ProgrammingFundamentalsWithJava2023.RegularExpressions.Exercise;

import java.util.Scanner;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] text = input.split(",\\s*");
        for (String demonName : text) {
            String[] parts = demonName.split("[^\\d+-.]+");
            //String regex = "/[0-9]+[+ - *\\\\\\/]*/";
            //String regexNum = "/[0-9]+[\\\\.]*[\\\\d]*/";
            // Pattern pattern = Pattern.compile(regex);
            //Pattern pattern1 = Pattern.compile(regexNum);

            int health = 0;
            double damage = 0.0;

            for (int i = 0; i < demonName.length(); i++) {
                if (!Character.isDigit(demonName.charAt(i)) && demonName.charAt(i) != '+'
                        && demonName.charAt(i) != '-' && demonName.charAt(i) != '*'
                        && demonName.charAt(i) != '/' && demonName.charAt(i) != '.') {
                    health += demonName.charAt(i);
                }
            }
            for (String part : parts) {
                if (part.matches("[+-]?\\d+(\\.\\d+)?")) {
                    damage += Double.parseDouble(part);
                }
            }
            for (int i = 0; i < demonName.length(); i++) {
                if (demonName.charAt(i) == '*') {
                    damage *= 2;
                } else if (demonName.charAt(i) == '/') {
                    damage /= 2;
                }
            }


            System.out.printf("%s - %d health, %.2f damage %n", demonName, health, damage);

        }
    }
}
