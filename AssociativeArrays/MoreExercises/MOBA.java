package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBA {

    class Player {
        String name;
        int totalSkill;
        Map<String, Integer> positions;

        public Player(String name) {
            this.name = name;
            this.totalSkill = 0;
            this.positions = new TreeMap<>();
        }

        public void addPosition(String position, int skill) {
            if (!positions.containsKey(position) || positions.get(position) < skill) {
                positions.put(position, skill);
                totalSkill += skill;
            }
        }
    }

    class MOBAChallenger {
        static Map<String, Player> players;

        public void main(String[] args) {
            players = new TreeMap<>();
            Scanner scanner = new Scanner(System.in);
            String line;
            while (!"Season end".equals(line = scanner.nextLine())) {
                String[] tokens = line.split(" -> | vs ");
                if (tokens.length == 3) {
                    // "{player} -> {position} -> {skill}"
                    String player = tokens[0];
                    String position = tokens[1];
                    int skill = Integer.parseInt(tokens[2]);
                    if (!players.containsKey(player)) {
                        players.put(player, new Player(player));
                    }
                    players.get(player).addPosition(position, skill);
                } else {
                    // "{player} vs {player}"
                    String player1 = tokens[0];
                    String player2 = tokens[1];
                    if (players.containsKey(player1) && players.containsKey(player2)) {
                        Player p1 = players.get(player1);
                        Player p2 = players.get(player2);
                        boolean duelHappened = false;
                        for (String position : p1.positions.keySet()) {
                            if (p2.positions.containsKey(position)) {
                                duelHappened = true;
                                if (p1.totalSkill > p2.totalSkill) {
                                    players.remove(p2.name);
                                } else if (p1.totalSkill < p2.totalSkill) {
                                    players.remove(p1.name);
                                }
                                break;
                            }
                        }
                        if (!duelHappened) {
                            // duel not happening
                        }
                    }
                }
            }

            // print players
            for (Player player : players.values()) {
                System.out.println(player.name + ": " + player.totalSkill + " skill");
                for (Map.Entry<String, Integer> entry : player.positions.entrySet()) {
                    System.out.println("- " + entry.getKey() + " <::> " + entry.getValue());
                }
            }
        }

    }
}
