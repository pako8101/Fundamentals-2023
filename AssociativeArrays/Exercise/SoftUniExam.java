package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.*;

public class SoftUniExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> submissions = new LinkedHashMap<>();
        Map<String, Integer> users = new LinkedHashMap<>();
        Map<String, Integer> banned = new LinkedHashMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("exam finished")) {
                break;
            }

            String[] tokens = line.split("-");
            String username = tokens[0];

            if (tokens[1].equals("banned")) {
                banned.put(username, users.get(username));
                users.remove(username);
                continue;
            }

            int points = Integer.parseInt(tokens[2]);
            if (!users.containsKey(username)) {
                users.put(username, points);
            } else {
                int currentPoints = users.get(username);
                if (points > currentPoints) {
                    users.put(username, points);
                }
            }

            if (!submissions.containsKey(tokens[1])) {
                submissions.put(tokens[1], 1);
            } else {
                submissions.put(tokens[1], submissions.get(tokens[1]) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedUsers = new ArrayList<>(users.entrySet());
        //sortedUsers.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : sortedUsers) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        List<Map.Entry<String, Integer>> sortedSubmissions = new ArrayList<>(submissions.entrySet());
        //sortedSubmissions.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : sortedSubmissions) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        sc.close();
    }
}

