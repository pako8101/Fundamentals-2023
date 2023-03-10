package ProgrammingFundamentalsWithJava2023.TextProcessing.Exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);
        int totalStrength = 0;
        for (int position = 0; position < text.length(); position++) {
            char currentSymbol = text.charAt(position);
            if (currentSymbol == '>') {
                //експлозия
                //char ('1') -> "1" ->int 1
                int attackStrength = Integer.parseInt
                        (text.charAt(position + 1) + "");//сила на експлозия
                totalStrength += attackStrength;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                //премахвам
                text.deleteCharAt(position);
                totalStrength--;
                position--;
            }
        }
        System.out.println(text);
    }
}
