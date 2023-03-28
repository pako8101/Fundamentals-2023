package ProgrammingFundamentalsRetakeExamPart210January2019;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Map<String, Map<String, Integer>> mapType = new LinkedHashMap<>();
        Map<String, Integer> mapAmount = new LinkedHashMap<>();

        while (!"END".equals(input = scanner.nextLine())) {
            String[] commands = input.split("->");
            if (commands[0].equals("Remove")) {
                String childName = commands[1];
                if (mapType.containsKey(childName)) {
                    mapType.remove(childName);
                }
            } else {
                String childName = commands[0];
                String typePresent = commands[1];
                int amount = Integer.parseInt(commands[2]);
                mapType.putIfAbsent(childName, new HashMap<>());
                mapType.get(childName).putIfAbsent(typePresent, 0);
                mapType.get(childName).put(typePresent,
                        mapType.get(childName).get(typePresent) + amount);
                mapAmount.putIfAbsent(typePresent, 0);
                mapAmount.put(typePresent, mapAmount.get(typePresent) + amount);

            }
        }
        System.out.println("Children:");
        mapType.entrySet().stream()
                .sorted((c1, c2) -> {
                    int total1 = c1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int total2 = c2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    if (total1 != total2) {
                        return Integer.compare(total2, total1); // descending order of total amount
                    } else {
                        return c1.getKey().compareTo(c2.getKey()); // ascending order of name
                    }
                })
                .forEach(c -> {
                    int total = c.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    System.out.printf("%s -> %d%n", c.getKey(), total);
                });

           /* for (Map.Entry<String, Map<String, Integer>> stringMapEntry : mapType.entrySet()) {
                String name = stringMapEntry.getKey();
                int totalAm = stringMapEntry.getValue().values().stream().mapToInt(Integer::intValue).sum();
                System.out.printf("%s -> %d%n", name, totalAm);
            }*/

        System.out.println("Presents:");
        mapAmount.entrySet().stream()
                /*.sorted((a, b) -> b.getValue().compareTo(a.getValue()))*/
                .forEach(e -> System.out.printf("%s -> %d%n", e.getKey(), e.getValue()));

    }
}
