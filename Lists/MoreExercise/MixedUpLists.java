package ProgrammingFundamentalsWithJava2023.Lists.MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> numbersList2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = numbersList2.size() - 1;
        while (i < numbersList1.size() && j >= 0) {
            result.add(numbersList1.get(i));
            result.add(numbersList2.get(j));
            i++;
            j--;
        }
        int start = result.get(result.size() - 2);
        int end = result.get(result.size() - 1);

        for (int num : result) {
            if (num >= start && num <= end) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

}
