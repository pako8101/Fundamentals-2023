package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGrade = new LinkedHashMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine());
        for (int student = 1; student <= countStudents ; student++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!studentGrade.containsKey(name)){
                studentGrade.put(name,new ArrayList<>());
            }
            studentGrade.get(name).add(grade);
        }
        Map<String,Double> averageGradeStudents = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>>entry: studentGrade.entrySet()) {
            String name = entry.getKey();
            List<Double>listGrades = entry.getValue();
            double averageGrade = getAverageGrade(listGrades);
            if (averageGrade >= 4.50){
                averageGradeStudents.put(name, averageGrade);
            }
        }
        averageGradeStudents.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }

    private static double getAverageGrade(List<Double> listGrades) {
        double sumAverage = 0;
        for (double averageGrade:listGrades) {
            sumAverage+=averageGrade;
        }return  sumAverage/ listGrades.size();
    }
}
