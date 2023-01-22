package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headSetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyBoardPrice = Double.parseDouble(scanner.nextLine());
        double monitorPrice = Double.parseDouble(scanner.nextLine());

        int countHeadSet = lostGames / 2;
        int countMouse = lostGames / 3;
        int countKeyBoard = lostGames / 6;
        int countMonitor = lostGames / 12;

        double total = 0.0;
        total = countHeadSet * headSetPrice + countMouse* mousePrice +
                countKeyBoard * keyBoardPrice + countMonitor * monitorPrice;

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
