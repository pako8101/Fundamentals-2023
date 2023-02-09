package ProgrammingFundamentalsWithJava2023.Lists.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] num = Arrays. stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        double leftTime = 0;
        double rightTime = 0;
        for (int i = 0; i < num.length; i++) {
            if (i< num.length/2){
                leftTime += num[i];
                if (num[i]==0){
                    leftTime*=0.8;
                }
            }else {
                rightTime+=num[i];
                if (num[i]== 0){
                    rightTime*=0.8;
                }
            }
        }if (leftTime<rightTime){
            System.out.printf("The winner is left with total time: %.1f\n", leftTime);
        }else {
            System.out.printf("The winner is right with total time: %.1f\n", rightTime);
        }

    }
}
