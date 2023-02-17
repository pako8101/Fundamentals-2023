package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employee1Efficiency = Integer.parseInt(scanner.nextLine());
        int employee2Efficiency = Integer.parseInt(scanner.nextLine());
        int employee3Efficiency = Integer.parseInt(scanner.nextLine());

        // for (int studentsPerHour = 0; studentsPerHour < 3 ; studentsPerHour++) {
        int totalEfficiency = employee1Efficiency + employee2Efficiency
                + employee3Efficiency;
        int countStudents = Integer.parseInt(scanner.nextLine());

        int count = 0;
        while (countStudents > 0) {
            count++;
            if (count % 4 != 0) {
                countStudents -= totalEfficiency;
            }

        }
        System.out.println("Time needed: " + count + "h.");
    }
}
