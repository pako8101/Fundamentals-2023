package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPreparation13February2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] chestArr = scanner.nextLine().split("\\|");
        List<String> chestList = new ArrayList<>(Arrays.asList(chestArr));

        List<String> commandList = Arrays.asList(scanner.nextLine().split(" "));
        while (!"Yohoho!".equals(commandList.get(0))) {

            String command = commandList.get(0);
            switch (command) {
                case "Loot":
                    List<String> loots = commandList.subList(1, commandList.size());
                    for (String item : loots) {
                        if (!chestList .contains(item)) {
                            chestList .add(0, item);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandList.get(1));
                    if (index >= 0 && index < chestList .size()) {
                        String removeItem = chestList .get(index);
                        chestList .remove(removeItem);
                        chestList .add(removeItem);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(commandList.get(1));
                    int result = chestList .size() - count;
                    List<String> stolen = new ArrayList<>();
                    if (result >= 0) {
                        for (int i = result; i < chestList .size(); i++) {
                            String item = chestList .remove(i--);
                            stolen.add(item);
                        }
                    } else {
                        for (int i = 0; i < chestList .size(); i++) {
                            String item = chestList .remove(i--);
                            stolen.add(item);
                        }
                    }
                    System.out.println(String.join(", ", stolen));
                    break;
            }
            commandList = Arrays.asList(scanner.nextLine().split(" "));
        }
            if (chestList .isEmpty()) {
                System.out.println("Failed treasure hunt.");
            } else {
                double totalLength = 0;
                for (String item : chestList ) {
                    totalLength += item.length();
                }
                double avGain = totalLength / chestList .size();
                System.out.printf("Average treasure gain: %.2f pirate credits.%n", avGain);
            }
        }
    }

