package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine()
                        .split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(text);
        String toPrint = text.toString().replaceAll("[\\]\\[,]", "").trim();
        toPrint = toPrint.replaceAll("\\s+", " ");

        System.out.println(toPrint);


    }
}

