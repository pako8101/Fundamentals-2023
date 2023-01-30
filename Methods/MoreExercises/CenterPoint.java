package ProgrammingFundamentalsWithJava2023.Methods.MoreExercises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine()) ;
        centerPoint(x1,y1,x2,y2);

    }
    public static void centerPoint(int x1, int y1, int x2, int y2){
        double distance1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double distance2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        if (distance1 < distance2) {
            System.out.println("(" + x1 + ", " + y1 + ")");
        } else {
            System.out.println("(" + x2 + ", " + y2 + ")");
        }
    }
}


