package ProgrammingFundamentalsWithJava2023.Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i <= numbersList.size() / 2; i++) {
            int first = numbersList.get(i);
            int second = numbersList.get(numbersList.size() - 1);

            numbersList.set(i, first + second);
            numbersList.remove(numbersList.size() - 1);

        }
        for (int item : numbersList
        ) {
            System.out.print(item + " ");

        }
    }
}
