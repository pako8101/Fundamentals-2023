package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = nextIntArray(scanner);
        int count = 0;
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int indexTarget = Integer.parseInt(input);
            if (isValidIndex(num, indexTarget)) {
                int shot = num[indexTarget];
                if (shot != -1) {
                    count++;
                    num[indexTarget] = -1;
                    registeredTargetHit(num, shot);
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        printArray(num, " ");
    }

    private static void registeredTargetHit(int[] num, int shot) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] != -1) {
                if (num[i] > shot) {
                    num[i] -= shot;
                }else {
                    num[i] += shot;
                }
            }
        }
    }

    private static boolean isValidIndex(int[] array, int targetIndex) {
        return targetIndex >= 0 && targetIndex < array.length;
    }

    private static void printArray(int[] array, String separator) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }

    private static int[] nextIntArray(Scanner scanner) {
        String[] intsAsStrings = scanner.nextLine().split("\\s+");
        int[] array = new int[intsAsStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(intsAsStrings[i]);
        }
        return array;
    }

}

