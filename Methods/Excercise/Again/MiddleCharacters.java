package ProgrammingFundamentalsWithJava2023.Methods.Excercise.Again;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        middleChar(word);
    }
    public static void middleChar(String word){
        word.toCharArray();
            if (word.length() %2 == 1){
                int middle = word.length()/2;
                System.out.println(word.charAt(middle));
            }else {
                int index1 = word.length() /2 -1;
                int index2 = word.length() / 2;
                System.out.println(word.charAt(index1) + "" + word.charAt(index2));
            }
        }
    }

