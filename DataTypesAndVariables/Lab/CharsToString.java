package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        char three = scanner.nextLine().charAt(0);

        String result = String.format("%s%s%s", one, two, three);
        System.out.println(result);
    }
}
