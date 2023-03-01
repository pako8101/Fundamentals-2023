package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> studentsStore = new HashMap<>();
        Map<String, Integer> studentPoints = new HashMap<>();

        while (!input.equals("exam finished")) {
            String[] student = input.split("-");
            String username = student[0];
            String language = student[1];
            int points = Integer.parseInt(student[2]);
            studentsStore.putIfAbsent(username, new ArrayList<>());
            studentsStore.get(username).add(language);
            studentPoints.putIfAbsent(language, points);
            List<String> banList = studentsStore.get(username);
            if (banList.contains("banned")) {
                studentsStore.remove(username);
                continue;
            }


            input = scanner.nextLine();
        }
        List<Map.Entry<String, List<String>>> sorted = new ArrayList<>(studentsStore.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));


        System.out.println("Submissions:");
        for (Map.Entry<String, List<String>> entry : studentsStore.entrySet()) {
            System.out.println(entry.getKey());
            for (String id : entry.getValue()) {
                System.out.println("|" + id);
            }


        }
    }
}