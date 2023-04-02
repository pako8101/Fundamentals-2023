package FundametalFinalExam02042023;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String bossData = scanner.nextLine();

            String regex = "(\\|)(?<name>[A-Z]{4,})\\1(:)(#)(?<title>[A-Za-z]+ [A-Za-z]+)(#)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(bossData);

            if (matcher.find()) {
                String bossName = matcher.group("name");
                String bossTitle = matcher.group("title");

                System.out.printf("%s, The %s%n>> Strength: %d%n>> Armor: %d%n", bossName, bossTitle, bossName.length(), bossTitle.length());

            } else {
                System.out.println("Access denied!");

            }


        }
    }

}

