package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class MOBA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> players = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] tokens = input.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                players.putIfAbsent(player, new LinkedHashMap<>());
                players.get(player).putIfAbsent(position, 0);
                int currentSkill = players.get(player).get(position);
                if (skill > currentSkill) {
                    players.get(player).put(position, skill);
                }
            } else {
                String[] tokens = input.split(" vs ");
                String player1 = tokens[0];
                String player2 = tokens[1];

                if (players.containsKey(player1) && players.containsKey(player2)) {
                    Map<String, Integer> positions1 = players.get(player1);
                    Map<String, Integer> positions2 = players.get(player2);

                    int totalSkill1 = positions1.values().stream().mapToInt(Integer::intValue).sum();
                    int totalSkill2 = positions2.values().stream().mapToInt(Integer::intValue).sum();

                    boolean hasCommonPosition = false;
                    for (String position : positions1.keySet()) {
                        if (positions2.containsKey(position)) {
                            hasCommonPosition = true;
                            break;
                        }
                    }

                    if (hasCommonPosition) {
                        if (totalSkill1 > totalSkill2) {
                            players.remove(player2);
                        } else if (totalSkill1 < totalSkill2) {
                            players.remove(player1);
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        players.entrySet().stream()
                .sorted((p1, p2) -> {
                    int totalSkill1 = p1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int totalSkill2 = p2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    if (totalSkill1 != totalSkill2) {
                        return Integer.compare(totalSkill2, totalSkill1);
                    } else {
                        return p1.getKey().compareTo(p2.getKey());
                    }
                })
                .forEach(player -> {
                    int totalSkill = player.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    System.out.printf("%s: %d skill%n", player.getKey(), totalSkill);

                    player.getValue().entrySet().stream()
                            .sorted((p1, p2) -> {
                                if (p1.getValue() != p2.getValue()) {
                                    return Integer.compare(p2.getValue(), p1.getValue());
                                } else {
                                    return p1.getKey().compareTo(p2.getKey());
                                }
                            })
                            .forEach(position -> {
                                System.out.printf("- %s <::> %d%n", position.getKey(), position.getValue());
                            });
                });
    }
}
