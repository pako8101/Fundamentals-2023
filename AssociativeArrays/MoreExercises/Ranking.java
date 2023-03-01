package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> contests = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("end of contest")) {
            String[] parts = line.split(":");
            String contest = parts[0];
            String password = parts[1];
            contests.put(contest, password);
            line = scanner.nextLine();
        }
        Map<String, Map<String, Integer>> users = new HashMap<>();
        line = scanner.nextLine();
        while (!line.equals("end of submissions")) {
            String[] parts = line.split("=>");
            String contest = parts[0];
            String password = parts[1];
            String username = parts[2];
            int points = Integer.parseInt(parts[3]);
            if (contests.containsKey(contest) &&
                    contests.get(contest).equals(password)) {
                if (users.containsKey(username)) {
                    Map<String, Integer> contestsPoints = users.get(username);
                    if (contestsPoints.containsKey(contest)) {
                        int currentPoints = contestsPoints.get(contest);
                        if (points > currentPoints) {
                            contestsPoints.put(contest, points);
                        } else {
                            contestsPoints.put(contest, points);
                        }
                    } else {
                        Map<String, Integer> contestPoints = new HashMap<>();
                        contestPoints.put(contest, points);
                        users.put(username, contestPoints);
                    }
                }
                line = scanner.nextLine();

            }
            String bestUser = "";
            int maxPoints = 0;
            for (Map.Entry<String, Map<String, Integer>> entry :
                    users.entrySet()) {
                String name = entry.getKey();
                Map<String, Integer>contestsPoints = entry.getValue();
                int totalPoints =0;
                for (int bestPoints:contestsPoints.values()) {
                    totalPoints += bestPoints;
                }
                if (totalPoints>maxPoints){
                    bestUser = name;
                    maxPoints=totalPoints;

                }
            }System.out.printf("Best candidate is %s with total %d points.", bestUser, maxPoints);
        }

    }
}


