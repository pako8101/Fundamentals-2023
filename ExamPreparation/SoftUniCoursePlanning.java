package ProgrammingFundamentalsWithJava2023.ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SoftUniCoursePlanning {

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Initialize a list to store the course schedule
            // Read the initial schedule of lessons
            String initialSchedule = scanner.nextLine();
            // Split the initial schedule into individual lessons and add them to the course schedule list
            String[] lessons = initialSchedule.split(", ");
            ArrayList<String> courseSchedule = new ArrayList<>(Arrays.asList(lessons));

            // Initialize a flag to indicate when the course start command is received
            boolean courseStart = false;
            // Read the commands
            while (!courseStart) {
                // Read the command
                String command = scanner.nextLine();

                // Check if the command is "course start"
                if (command.equals("course start")) {
                    // Set the course start flag to true
                    courseStart = true;
                } else {
                    // Split the command into its individual parts
                    String[] parts = command.split(":");
                    String action = parts[0];
                    String lesson = parts[1];

                    // Check the action to be taken
                    if (action.equals("Add")) {
                        // Add the lesson to the end of the course schedule if it doesn't already exist
                        if (!courseSchedule.contains(lesson)) {
                            courseSchedule.add(lesson);
                        }
                    } else if (action.equals("Insert")) {
                        // Insert the lesson at the specified index if it doesn't already exist
                        int index = Integer.parseInt(parts[2]);
                        if (!courseSchedule.contains(lesson)) {
                            courseSchedule.add(index, lesson);
                        }
                    } else if (action.equals("Remove")) {
                        // Remove the lesson from the course schedule if it exists
                        if (courseSchedule.contains(lesson)) {
                            courseSchedule.remove(lesson);
                        }
                    } else if (action.equals("Swap")) {
                        // Swap the positions of the two lessons if they both exist in the course schedule
                        String lesson2 = parts[2];
                        if (courseSchedule.contains(lesson) && courseSchedule.contains(lesson2)) {
                            int index1 = courseSchedule.indexOf(lesson);
                            int index2 = courseSchedule.indexOf(lesson2);
                            String temp = courseSchedule.get(index1);
                            courseSchedule.set(index1, courseSchedule.get(index2));
                            courseSchedule.set(index2, temp);
                        }
                    } else if (action.equals("Exercise")) {
                        // Add the Exercise after the lesson if the lesson exists and there is no Exercise already
                        if (courseSchedule.contains(lesson)) {
                            int index = courseSchedule.indexOf(lesson);
                            if (index + 1 < courseSchedule.size() && courseSchedule.get(index + 1).equals(lesson + "-Exercise")){

                            }

                        }
                    }
                }
            }
        }
    }
}
