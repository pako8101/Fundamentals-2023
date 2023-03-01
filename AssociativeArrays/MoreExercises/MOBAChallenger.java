package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
   static Map<String,Player> players;

    public static void main(String[] args) {
       players = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Season end")) {

            String[] token = input.split("-> | vs");
            if (token.length == 3) {
                String player = token[0];
                String position = token[1];
                int skill = Integer.parseInt(token[2]);
                players.get(player);
                if (players.containsKey(player)) {
                    players.put(player, new Player(position));
                }
                players.get(player).addPosition(player, skill);
            } else {
                String player1 = token[0];
                String player2 = token[1];
                if (players.containsKey(player1) || players.containsKey(player2)) {
                    Player p1 = players.get(player1);
                    Player p2 = players.get(player2);
                    boolean duelHappened = false;
                    for (String position : p1.positions.keySet()) {
                        if (p2.positions.containsKey(position)) {
                            duelHappened = true;
                            if (p1.totalSkill > p2.totalSkill) {
                                players.remove(p2.name);
                            } else  {
                                players.remove(p1.name);
                            }
                            break;
                        }
                    }
                    if (!duelHappened) {

                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Player player : players.values()) {
            System.out.println(player.name + ": " + player.totalSkill + "skill");
            for (Map.Entry<String, Integer> entry : player.positions.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " <::>");
            }
        }

    }

    static class Player {
        private String name;
        private Integer totalSkill;
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
}