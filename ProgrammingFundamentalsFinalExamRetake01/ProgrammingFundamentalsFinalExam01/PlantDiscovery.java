package ProgrammingFundamentalsFinalExam01;

import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> ratingPlants = new LinkedHashMap<>();
        Map<String, Integer> rarityPlants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] arrStrings = scanner.nextLine().split("<->");
            String plant = arrStrings[0];
            int rarity = Integer.parseInt(arrStrings[1]);
            ratingPlants.put(plant, 0.0);
            rarityPlants.put(plant, rarity);
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] commands = input.split("[: -]+");
            String name = commands[1];
            if (!rarityPlants.containsKey(name)) {
                System.out.println("error");
            } else {
                switch (commands[0]) {
                    case "Rate":
                        double rating = Double.parseDouble(commands[2]);
                        if (ratingPlants.get(name) == 0) {
                            ratingPlants.put(name, rating);
                        } else {
                            double newRating = ratingPlants.get(name) + rating;
                            ratingPlants.put(name, newRating / 2);
                        }
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(commands[2]);
                        rarityPlants.put(name, newRarity);
                        break;
                    case "Reset":
                        ratingPlants.put(name, 0.0);
                        break;
                }
            }
                input = scanner.nextLine();
            }
            System.out.println("Plants for the exhibition:");
            for (Map.Entry<String, Integer> entry : rarityPlants.entrySet()) {
                System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(),
                        entry.getValue(), ratingPlants.get(entry.getKey()));
            }
        }
    }
