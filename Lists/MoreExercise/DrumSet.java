package ProgrammingFundamentalsWithJava2023.Lists.MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        int[] drumSet = nextIntArray(scanner,"@");
        String input = scanner.nextLine();
        List<Integer> quality = new ArrayList<>();
        for (int i = 0; i < drumSet.length; i++) {
            quality.add(drumSet[i]);
        }
        while (!input.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < drumSet.length; i++) {
                drumSet[i]-=hitPower;
                for (int j = 0; j < drumSet.length; j++) {
                    if (drumSet[i]<= 0){
                        if (savings - quality.get(i) * 3 >0){
                            drumSet[i] = quality.get(i);
                            savings -= quality.get(i);
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }
    }
    private static int[] nextIntArray(Scanner scanner,String separator) {
        String[] intsAsStrings = scanner.nextLine().split(separator);
        int[] array = new int[intsAsStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(intsAsStrings[i]);
        }
        return array;
    }
}
