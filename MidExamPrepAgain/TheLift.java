package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] liftState = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCurrWagon = 0;
        int peopleOnTheLift = 0;
        boolean NoMorePeople = false;

        for (int i = 0; i < liftState.length; i++) {
            while (liftState[i] < 4) {
                liftState[i]++;
                peopleCurrWagon++;
                if (peopleOnTheLift + peopleCurrWagon == peopleWaiting) {
                    NoMorePeople = true;
                    break;
                }
            }
            peopleOnTheLift += peopleCurrWagon;
            if (NoMorePeople) {
                break;
            }
            peopleCurrWagon = 0;
        }
        if (peopleWaiting > peopleOnTheLift) {
            int peopleQueue = peopleWaiting - peopleOnTheLift;
            System.out.println("There isn't enough space! " + peopleQueue
                    + " people in a queue!");
        } else {
            System.out.println("The lift has empty spots!");
        }
        for (int spots : liftState) {

            System.out.print(spots + " ");
        }
    }
}
