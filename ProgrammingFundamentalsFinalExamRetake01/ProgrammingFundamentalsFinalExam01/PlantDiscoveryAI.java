package ProgrammingFundamentalsFinalExam01;

import java.util.*;

public class PlantDiscoveryAI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> rarities = new HashMap<>();
        Map<String, List<Integer>> ratings = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("(<->)");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            rarities.put(plant, rarity);
            ratings.put(plant, new ArrayList<>());
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] tokens = input.split("(:\\s+|-\\s+)");
            String command = tokens[0];
            String plant = tokens[1];

            if (!rarities.containsKey(plant)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command) {
                case "Rate":
                    int rating = Integer.parseInt(tokens[2]);
                    ratings.get(plant).add(rating);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(tokens[2]);
                    rarities.put(plant, newRarity);
                    break;
                case "Reset":
                    ratings.put(plant, new ArrayList<>());
                    break;
                default:
                    System.out.println("error");
            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        rarities.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    String plant = entry.getKey();
                    int rarity = entry.getValue();
                    List<Integer> plantRatings = ratings.get(plant);
                    double averageRating = 0.0;
                    if (!plantRatings.isEmpty()) {
                        averageRating = plantRatings.stream().mapToInt(Integer::intValue).average().getAsDouble();
                    }
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant, rarity, averageRating);
                });
    }

}
