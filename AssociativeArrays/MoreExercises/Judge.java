package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,TreeMap<String, Integer>> contests = new TreeMap<>();
        Map<String, Integer> individualStands = new TreeMap<>();

        while (true){
        String input = scanner.nextLine();
        if ("no more time".equals(input)) {
            break;
        }
            String[] parts = input.split("->");
            String username = parts[0];
            String contest = parts[1];
            int points = Integer.parseInt(parts[2]);

            if (!contests.containsKey(contest)) {
                contests.put(contest, new TreeMap<>());
            }

            TreeMap<String, Integer> participants = contests.get(contest);
            participants.put(username,Math.max(points, participants.getOrDefault(username, 0)));
            individualStands. put(username, individualStands.getOrDefault(username,0)+points);
            }
        for (Map.Entry<String, TreeMap<String, Integer>> entry: contests.entrySet()){
            String contest = entry.getKey();
            TreeMap<String, Integer> participants = entry.getValue();
            System.out.printf("%s: %d participants%n", contest,participants.size());
            int position = 1;
            for (Map.Entry<String, Integer>participant: participants.entrySet()){
                String username = participant.getKey();
                int points = participant.getValue();
                System.out.printf("%d. %s <::> %d%n", position, username, points);
                position++;
            }

        }
        System.out.println("Individual standings:");
        int position = 1;
        for (Map.Entry<String, Integer>entry: individualStands.entrySet()) {
            String username = entry.getKey();
            int points = entry.getValue();
            System.out.printf("%d. %s -> %d%n", position, username, points);
            position++;
        }



        }
    }

