package ProgrammingFundamentalsWithJava2023.ObjectsAndClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person>personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());//бр.редове с лична информация
        for (int row = 1; row <= n ; row++) {
            String personData = scanner.nextLine();
            //"име възраст".split("")->["име", "възраст"]
            String name = personData.split(" ")[0];
            int age =Integer.parseInt(personData.split(" ")[1]);
            if (age>30){
                //създавам запис за човека ->съхранявам запис
                Person person = new Person(name, age);
                personList.add(person);
            }
        }
        for (Person person:personList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
