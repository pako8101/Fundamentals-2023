package ProgrammingFundamentalsFinalExam03;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cities;
        Map<String, int[]> mapCity = new TreeMap<>();
        String input;
        while (!"Sail".equals(input = scanner.nextLine())) {
            cities = input.split("(\\s+)?(\\|{2})(\\s+)?");
            String city = cities[0];
            int population = Integer.parseInt(cities[1]);
            int gold = Integer.parseInt(cities[2]);
            if (!mapCity.containsKey(city)) {
                mapCity.put(city, new int[2]);
                mapCity.get(city)[0] = population;
                mapCity.get(city)[1] = gold;
            } else {
                int newPopulation =  mapCity.get(city)[0];
                int newGold =  mapCity.get(city)[1];
                mapCity.get(city)[0] = newPopulation + population;
                mapCity.get(city)[1] = newGold + gold;
            }
        }

        while (!"End".equals(input = scanner.nextLine())) {
            cities = input.split("=>");
            String event = cities[0];
            String city = cities[1];
            switch (event) {
                case "Plunder":
                    int people = Integer.parseInt(cities[2]);
                    int goldPlunder = Integer.parseInt(cities[3]);
                    int currentPeople = mapCity.get(city)[0];
                    int currentGold = mapCity.get(city)[1];
                    System.out.printf("%s plundered! %d gold stolen, " +
                            "%d citizens killed.\n", city, goldPlunder, people);
                    currentPeople -= people;
                    currentGold -= goldPlunder;
                    mapCity.get(city)[0] = currentPeople;
                    mapCity.get(city)[1] = currentGold;
                    if (currentPeople == 0 || currentGold == 0) {
                        mapCity.remove(city);
                        System.out.printf("%s has been wiped off the map!\n", city);
                    }
                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(cities[2]);
                    int currentGoldProsper = mapCity.get(city)[1];
                    if (goldProsper <= 0) {
                        System.out.println("Gold added cannot be a negative number!");

                    } else {
                        currentGoldProsper += goldProsper;
                        mapCity.get(city)[1] = currentGoldProsper;
                        System.out.printf("%d gold added to the city treasury. " +
                                "%s now has %d gold.\n", goldProsper, city, currentGoldProsper);
                    }
                    break;
                default:
                    break;
            }
        }
        if (mapCity.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have " +
                    "been plundered and destroyed!");

        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements " +
                    "to go to:%n", mapCity.size());
            mapCity.entrySet().stream().
                    sorted((a, b) -> Integer.compare(b.getValue()[1], a.getValue()[0]))
                    .forEach(entry ->
                            System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                                    entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
        }
    }
}
