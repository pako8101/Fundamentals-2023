package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<String> namesIn = new ArrayList<>();


        for (int i = 1; i <= count; i++) {
            String message = scanner.nextLine();
           String[] messages = message.split(" ");

            boolean isInTheList = false;
                if (!"not".equalsIgnoreCase(messages[2])) {
                    for (String people: namesIn) {
                        if (people.equals(messages[0])){
                            isInTheList=true;
                            break;
                        }
                }  if (isInTheList) {
                    System.out.printf("%s is already in the list!%n",messages[0] );
                } else {
                        namesIn.add(messages[0]);
                    }
            } else {
                if (!namesIn.contains(messages[0])) {
                    System.out.printf("%s is not in the list!%n", messages[0]);
                } else {
                    namesIn.remove(messages[0]);
                }
            }
            } for (String people : namesIn
            ) {
                System.out.println(people);
        }
    }
}
