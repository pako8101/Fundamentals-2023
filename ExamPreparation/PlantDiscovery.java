package ProgrammingFundamentalsWithJava2023.ExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsNameRarity = new HashMap<>();
        Map<String, Double> ratingPlantsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantArr = scanner.nextLine().split("<->");
            String namePlanet = plantArr[0];
            int rarity = Integer.parseInt(plantArr[1]);

            ratingPlantsMap.put(namePlanet, 0.0);
            plantsNameRarity.put(namePlanet, rarity);
        }
            String input = scanner.nextLine();
            while (!input.equals("Exhibition")) {
                String[] tokens = input.split("[: -]+");
                String command = tokens[0];
                String plant = tokens[1];
                double value = 0;
                if (!plantsNameRarity.containsKey(plant)) {
                    System.out.println("error");
                } else {
                    switch (command) {
                        case "Rate":

                            Double rate = Double.parseDouble(tokens[2]);
                            if (ratingPlantsMap.get(plant) == 0) {
                                ratingPlantsMap.put(plant, rate);
                            } else {
                                double newRate = ratingPlantsMap.get(plant) + rate;
                                ratingPlantsMap.put(plant, newRate / 2);
                            }

                            break;
                        case "Update":
                            int rare = Integer.parseInt(tokens[2]);
                            plantsNameRarity.put(plant, rare);

                            break;
                        case "Reset":
                            ratingPlantsMap.put(plant, 0.0);
                            break;
                    }
                }
                input = scanner.nextLine();
            }
            System.out.println("Plants for the exhibition:");
            for (Map.Entry<String, Integer> entry : plantsNameRarity.entrySet()) {
                System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(),
                        entry.getValue(), ratingPlantsMap.get(entry.getKey()));

            }
        }
    }

