package ProgrammingFundamentalsWithJava2023.TextProcessing.MoreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        String random = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i <random.length() ; i++) {
            char c = random.charAt(i);
            if (c>= symbol1 && c<=symbol2){
                sum+= c;
            }

        }
        System.out.println(sum);

    }
}
