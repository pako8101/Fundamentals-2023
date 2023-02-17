package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.text.DecimalFormat;
import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        DecimalFormat df = new DecimalFormat("0.##");
        double average = 0;
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            //sum = Arrays.stream(numbers).sum();
        }
        average = 1.0 * sum / numbers.length;
        double total = Double.parseDouble(df.format(average));
        List<Integer> aboveAvg = new ArrayList<>();
        for (int num : numbers) {
            if (num > total) {
                aboveAvg.add(num);
            }
        }

        if (aboveAvg.isEmpty()) {
            System.out.println("No");
        } else {
            aboveAvg.sort(Collections.reverseOrder());
            int count = Math.min(aboveAvg.size(), 5);
            for (int i = 0; i < count; i++) {
                System.out.print(aboveAvg.get(i) + " ");
            }
        }
    }

}




