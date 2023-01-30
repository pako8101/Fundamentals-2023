package ProgrammingFundamentalsWithJava2023.Methods.MoreExercises;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                // Read coordinates of the first line
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();

                // Read coordinates of the second line
                int x3 = scanner.nextInt();
                int y3 = scanner.nextInt();
                int x4 = scanner.nextInt();
                int y4 = scanner.nextInt();

                // Calculate the length of the two lines
                double length1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                double length2 = Math.sqrt((x3 - x4) * (x3 - x4) + (y3 - y4) * (y3 - y4));

                // Check which line is longer
                if (length1 > length2) {
                    // Print the first line
                    printLine(x1, y1, x2, y2);
                } else if (length2 > length1) {
                    // Print the second line
                    printLine(x3, y3, x4, y4);
                } else {
                    // The lines are of equal length, print the first line
                    printLine(x1, y1, x2, y2);
                }
            }

            public static void printLine(int x1, int y1, int x2, int y2) {
                // Check which point is closer to the center of the coordinate system
                double distance1 = Math.sqrt(x1 * x1 + y1 * y1);
                double distance2 = Math.sqrt(x2 * x2 + y2 * y2);
                if (distance1 < distance2) {
                    System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
                } else {
                    System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
                }
            }
        }
