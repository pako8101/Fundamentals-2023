package FundametalFinalExam02042023;

import java.util.*;

public class TaskThird {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> herroMap = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            String command = commands[0];
            String herroName = commands[1];
            if (command.equals("Enroll")) {
                if (!herroMap.containsKey(herroName)) {
                    herroMap.put(herroName, new ArrayList<>());
                } else {
                    System.out.printf("%s is already enrolled.%n", herroName);
                }
            }
            if (command.equals("Learn")) {
                String spellName = commands[2];
                if (herroMap.containsKey(herroName)) {
                    List<String> spellbook = herroMap.get(herroName);
                    if (!spellbook.contains(spellName)) {
                        spellbook.add(spellName);
                    } else {
                        System.out.printf("%s has already learnt %s.%n", herroName, spellName);
                    }
                } else {
                    System.out.printf("%s doesn't exist.%n", herroName);
                }

            }
            if (command.equals("Unlearn")) {
                String spellName = commands[2];
                if (herroMap.containsKey(herroName)) {
                    List<String> spellbook = herroMap.get(herroName);
                    if (spellbook.contains(spellName)) {
                        spellbook.remove(spellName);
                    } else {
                        System.out.printf("%s doesn't know %s.%n", herroName, spellName);
                    }
                } else {
                    System.out.printf("%s doesn't exist.%n", herroName);
                }
            }

            input = scanner.nextLine();
        }

//        System.out.println("Heroes:");
//        herroMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(hero -> {
//                    System.out.printf("== %s: ", hero.getKey());
//                    System.out.print(String.join(", ", hero.getValue()));
//                    System.out.println();
//                });
        System.out.print("Heroes:");
        //.sorted(Map.Entry.comparingByKey())
        herroMap.forEach((key, value) -> {
            System.out.printf("%n== %s: ", key);
            if (!value.isEmpty()) {
                System.out.print(String.join(", ", value));
            }
        });
    }
}

