package ProgrammingFundamentalsWithJava2023.RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countMess = Integer.parseInt(scanner.nextLine());
        String regex = "([\\w]+)[-@!:>]*([\\d])[-@!:>]*+([AD]!)[-@!:>]*->([\\d]+)[-@!:>]*";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackerPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();
        for (int messageCount = 1; messageCount < countMess; messageCount++) {
            String encryptedMess = scanner.nextLine();
            String decryptedMess = getDecryptedMess(encryptedMess);
            String[] parts = decryptedMess.split("[^@:!->]");
                String planetName = parts[1];
                String attackType = parts[3];
                StringBuilder builder = new StringBuilder();
                if (attackType.equals("A")) {
                    attackerPlanet.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanet.add(String.valueOf(planetName));
                }
            }

        System.out.println("Attacked planets: " + attackerPlanet.size());
        Collections.sort(attackerPlanet);
        for (String planet: attackerPlanet) {
            System.out.println("-> " + planet);
        }

        System.out.println("Destroyed planets: " + destroyedPlanet.size());
        Collections.sort(destroyedPlanet);
        for (String planet: destroyedPlanet) {
            System.out.println("-> " + planet);
        }

    }
        private static String getDecryptedMess(String encryptedMess) {
            int countLetters = getSpecialLettersCount(encryptedMess);
            StringBuilder decryptedMess = new StringBuilder();
            for (char symbol : encryptedMess.toCharArray()) {
                char newSymbol = (char) (symbol - countLetters);
                decryptedMess.append(newSymbol);
            }
            return decryptedMess.toString();
        }

        private static int getSpecialLettersCount(String encryptedMess) {
            int count = 0;
            for (char symbol : encryptedMess.toCharArray()) {
                switch (symbol) {
                    case 'a':
                    case 't':
                    case 's':
                    case 'r':
                    case 'S':
                    case 'T':
                    case 'A':
                    case 'R':
                        count++;
                        break;
                }
            }
            return count;
        }
    }

/*class Planet implements Comparable<Planet> {
    String name;
    int population;
    String attackType;
    int soldiers;

    public Planet(String name, int population, String attackType, int soldiers) {
        this.name = name;
        this.population = population;
        this.attackType = attackType;
        this.soldiers = soldiers;
    }

    public int compareTo(Planet other) {
        return this.name.compareTo(other.name);
    }*/
