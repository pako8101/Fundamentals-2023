package ProgrammingFundamentalsWithJava2023.MidExam19022023;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int countOfWorkers = Integer.parseInt(scanner.nextLine());
        int biscuitsPerMonth = Integer.parseInt(scanner.nextLine());
        int biscuitsProduction = 0;
        double difference = 0;
        double percentDiff = 0;
        double total = 0;
        for (int days = 0; days < 30; days++) {
            biscuitsProduction = biscuitsPerDay * countOfWorkers;
            if (days % 3 == 0) {
                biscuitsProduction = (int) Math.floor(biscuitsProduction * 0.75);
            }
            total += biscuitsProduction;


            percentDiff = (total / biscuitsPerMonth - 1) * 100;
        }
        System.out.printf("You have produced %.0f biscuits for the past month.%n",
                total);
        if (percentDiff > 0) {
            System.out.printf("You produce %.2f percent more biscuits.", percentDiff);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", -percentDiff);
        }
    }


}
