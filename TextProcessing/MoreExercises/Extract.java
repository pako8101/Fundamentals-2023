package ProgrammingFundamentalsWithJava2023.TextProcessing.MoreExercises;

import java.util.Scanner;

public class Extract{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
       // int indexLast = path.lastIndexOf("\\\\");
       // String fullNam = path.substring(indexLast + 1);
        String [] pahParts = path.split("\\\\");
        String fulName = pahParts[pahParts.length-1];
        String fileName = fulName.split("\\.")[0];
        String extension = fulName.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("Extension: " + extension);
    }
}
