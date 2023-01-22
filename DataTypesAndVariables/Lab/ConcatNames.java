package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameFirst = scanner.nextLine();
        String nameSecond = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = String.format("%s%s%s", nameFirst,delimiter, nameSecond);
        /*System.out.printf("%s%s%s", nameFirst, delimiter, nameSecond);*/
        System.out.println(result);
    }
}
