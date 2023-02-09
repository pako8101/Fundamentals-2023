package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayerNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayerNumbers.size() > 0 && secondPlayerNumbers.size() > 0) {
            int firstCard = firstPlayerNumbers.remove(0);
            int secondCard = secondPlayerNumbers.remove(0);
            if (firstCard > secondCard) {
                firstPlayerNumbers.add(firstCard);
                firstPlayerNumbers.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayerNumbers.add(secondCard);
                secondPlayerNumbers.add(firstCard);
            } else {
                firstPlayerNumbers.remove(0);
                secondPlayerNumbers.remove(0);

            }
            /*if (firstPlayerNumbers.size() > 0) {
                sum1 += firstCard + secondCard;
            } else if (secondPlayerNumbers.size()>0) {
                sum2 += firstCard + secondCard;
            }*/
        }
        int sum = 0;
        if (firstPlayerNumbers.size()==0) {
            for (Integer card:secondPlayerNumbers) {
                sum+=card;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            for (Integer card: firstPlayerNumbers) {
                sum+=card;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }

    }
}