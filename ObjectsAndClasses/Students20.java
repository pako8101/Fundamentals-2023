package ProgrammingFundamentalsWithJava2023.ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students20 {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;

        public Student(String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String setTown() {
            return this.town;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> studentsList = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studentsDataArr = input.split(" ");
            String firstName = studentsDataArr[0];
            String lastName = studentsDataArr[1];
            String age = studentsDataArr[2];
            String town = studentsDataArr[3];

            if (isStudentExisting(studentsList, firstName, lastName)) {
                int index = getExistingIndex(studentsList,firstName,lastName);
                studentsList.get(index).setAge(age);
                studentsList.get(index).setTown(town);

            } else {
                Student currentStudent = new Student(firstName, lastName, age, town);
                studentsList.add(currentStudent);
            }


            input = scanner.nextLine();
        }
        String homeTown = scanner.nextLine();
        for (Student student : studentsList) {
            if (homeTown.equals(student.getTown())) {
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    public static int getExistingIndex(List<Student> studentList,
                                       String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                index = i;
            }
        }return index;
    }

    static boolean isStudentExisting(List<Student>studentList, String firstName,String lastName){
        for (Student student: studentList){
            if (student.getFirstName().equals(firstName)&&
                    student.getLastName().equals(lastName)){
                return true;
            }
        }return false;
    }
}
