package ProgrammingFundamentalsWithJava2023.TextProcessing.MoreExercises;

import java.util.HashMap;
import java.util.Scanner;


public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println(MorseCodeTranslator.translate(String.valueOf(message)));

    }
    public static final HashMap<String, String> morseCodes = new HashMap<>();


    static {
        morseCodes.put(".-", "A");
        morseCodes.put("-...", "B");
        morseCodes.put("-.-.", "C");
        morseCodes.put("-..", "D");
        morseCodes.put(".", "E");
        morseCodes.put("..-.", "F");
        morseCodes.put("--.", "G");
        morseCodes.put("....", "H");
        morseCodes.put("..", "I");
        morseCodes.put(".---", "J");
        morseCodes.put("-.-", "K");
        morseCodes.put(".-..", "L");
        morseCodes.put("--", "M");
        morseCodes.put("-.", "N");
        morseCodes.put("---", "O");
        morseCodes.put(".--.", "P");
        morseCodes.put("--.-", "Q");
        morseCodes.put(".-.", "R");
        morseCodes.put("...", "S");
        morseCodes.put("-", "T");
        morseCodes.put("..-", "U");
        morseCodes.put("...-", "V");
        morseCodes.put(".--", "W");
        morseCodes.put("-..-", "X");
        morseCodes.put("-.--", "Y");
        morseCodes.put("--..", "Z");

    }

    public static String translate(String message) {
        StringBuilder translatedMessage = new StringBuilder();
        String[] words = message.split("\\|");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                translatedMessage.append(morseCodes.get(letter));
            }
            translatedMessage.append(" ");
        }
        return translatedMessage.toString().trim();
    }
}




