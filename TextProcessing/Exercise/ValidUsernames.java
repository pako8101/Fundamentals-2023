package ProgrammingFundamentalsWithJava2023.TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] userNamesArr = input.split(", ");

        for (String username : userNamesArr) {
            if (isValidUser(username)) {
                System.out.println(username);
            }

        }
    }

    //метод който проверява username е валиден
    //true метода е валиден
    //false метода е невалиден
    public static boolean isValidUser(String username) {
            //boolean isValid = username.length()>=3 && username.length()<=16;
            if (username.length() < 3 || username.length() > 16) {
                return false;
            }

            //boolean isValidContent = false;
            for (char symbol : username.toCharArray()) {
                if (!Character.isLetterOrDigit(symbol) && symbol != '_' && symbol != '-') {
                    return false;
                }
            }return true;

        }
    }
