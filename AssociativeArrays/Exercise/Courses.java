package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] arr = input.split(" : ");
            String courseName = arr[0];
            String studentName = arr[1];
            //courses.putIfAbsent(courseName,new ArrayList<>());

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(studentName);

            input = scanner.nextLine();
        }
        for (String course : courses.keySet()) {
            System.out.println(course + ": " + courses.get(course).size());
            for (String name : courses.get(course)) {
                System.out.println("-- " + name);
            }
        }

    }
}
