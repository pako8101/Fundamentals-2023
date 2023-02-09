package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> course = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            String[] commands = input.split(":");
            String command = commands[0];
            String lessonTitle = commands[1];
            if (command.equals("Add")) {
                if (!course.contains(lessonTitle)) {
                    course.add(lessonTitle);
                }
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(commands[2]);
                if (!course.contains(lessonTitle)) {
                    course.add(index, lessonTitle);
                }
            } else if (command.equals("Remove")) {
                if (course.contains(lessonTitle)) {
                    course.remove(lessonTitle);
                }
            } else if (command.equals("Swap")) {
                String lesson1 = commands[1];
                String lesson2 = commands[2];
                if (course.contains(lesson1) && course.contains(lesson2)) {
                    String index1 = course.get(Integer.parseInt(lesson1));
                    String index2 = course.get(Integer.parseInt(lesson2));
                    course.add(Integer.parseInt(index1), lesson2);
                    course.add(Integer.parseInt(index2), lesson1);
                }
            } else if (command.equals("Exercise")) {
                String[] exerciseArr = lessonTitle.split("-");
                String lesson = exerciseArr[0];
                String exercise = exerciseArr[1];
                if (!course.contains(lesson)) {
                    course.add(lesson);
                    course.add(exercise);
                } else {
                    course.add(exercise);
                }
            }


            input = scanner.nextLine();
        }
        int count = 0;
        for (int i = 0; i <= course.size() - 1; i++) {
            count++;
            System.out.printf("%d.%s%n", count, course.get(i));
        }
    }
}
