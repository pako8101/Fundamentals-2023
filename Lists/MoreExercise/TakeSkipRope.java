package ProgrammingFundamentalsWithJava2023.Lists.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regexNumbers = "[\\d]+";
        Pattern pattern = Pattern.compile(regexNumbers);
        Matcher matcherNumbers = pattern.matcher(text);
        List<Integer> numbers = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        while (matcherNumbers.find()) {
            numbers.add(Integer.valueOf(matcherNumbers.group()));
        }
        String regexLetters = "[\\w]+";
        Pattern pattern1 = Pattern.compile(regexLetters);
        Matcher matcherLetters = pattern1.matcher(text);
        List<String> letters = new ArrayList<>();
        while (matcherLetters.find()) {
            letters.add(matcherLetters.group());
        }
        for (int i = 0; i <text.length() ; i++) {
            if (i % 2 == 0) {
                takeList.add(i);
            } else {
                skipList.add(i);

            }
        }
        StringBuilder result = new StringBuilder();
        int skipCount = 0;
        for (int i = 0; i < takeList.size(); i++) {
            skipCount += skipList.get(i);
            result.append(letters.subList(skipCount, skipCount + takeList.get(i)));
            skipCount += takeList.get(i);
        }
        System.out.println(result);
    }
}
/*
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String encryptedMessage = "skipTest_String044170";
    String decryptedMessage = decrypt(encryptedMessage);
    System.out.println(decryptedMessage);
  }

  public static String decrypt(String encryptedMessage) {
    List<Integer> takeList = new ArrayList<>();
    List<Integer> skipList = new ArrayList<>();
    List<Character> nonNumbers = new ArrayList<>();
    for (int i = 0; i < encryptedMessage.length(); i++) {
      char c = encryptedMessage.charAt(i);
      if (Character.isDigit(c)) {
        int digit = Character.getNumericValue(c);
        if (i % 2 == 0) {
          takeList.add(digit);
        } else {
          skipList.add(digit);
        }
      } else {
        nonNumbers.add(c);
      }
    }

    StringBuilder result = new StringBuilder();
    int skipCount = 0;
    for (int i = 0; i < takeList.size(); i++) {
      skipCount += skipList.get(i);
      result.append(nonNumbers.subList(skipCount, skipCount + takeList.get(i)));
      skipCount += takeList.get(i);
    }
    return result.toString();
  }
}

 */