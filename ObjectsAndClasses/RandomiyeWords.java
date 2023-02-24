package ProgrammingFundamentalsWithJava2023.ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomiyeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words= input.split(" ");
        Random rndGen = new Random();

        for (int i = 0; i < words.length; i++) {
            int indexX = rndGen.nextInt(words.length);
            int indexY = rndGen.nextInt(words.length);

            String oldWordX = words[indexX];
            words[indexX]= words[indexY];
            words[indexY] = oldWordX;
        }
        System.out.println(String.join(System.lineSeparator(),words));


    }
}
