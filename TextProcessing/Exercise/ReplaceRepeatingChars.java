package ProgrammingFundamentalsWithJava2023.TextProcessing.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ch = scanner.nextLine().toCharArray();
                List<Character> characterList = new ArrayList<>();
                for (int i = 0; i < ch.length; i++) {
                    characterList.add(ch[i]);
                }

        for (int i = 1; i < characterList.size(); i++) {
            char current = characterList.get(i-1);
            char plus = characterList.get(i);
            if (current == plus) {
                characterList.remove(i);
                i--;
            }
        }
        for (Character letter : characterList) {
            System.out.print(letter);

        }
    }
}
