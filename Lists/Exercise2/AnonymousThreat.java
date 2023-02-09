package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (command.equals("3:1")) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("merge")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                if (startIndex <= text.size() - 1 && endIndex >= 0 &&
                        startIndex > endIndex) {
                    String mergeIndex = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        String resultText = text.get(i);
                        mergeIndex += resultText;
                        text.remove(startIndex);
                        text.add(startIndex, mergeIndex);

                    }
                } else if (tokens[0].equals("divide")) {
                    int element = Integer.parseInt(tokens[1]);
                    int partitions = Integer.parseInt(tokens[2]);
                    String elementForDivide = text.get(element);
                    text.remove(element);
                    int partSize = elementForDivide.length() / partitions;
                    int remaining = elementForDivide.length() % partitions;
                    int beginIndex = 0;
                    for (int part = 1; part < partitions; part++) {
                        if (part == partitions - 1) {
                            text.add(element + part, elementForDivide.substring(part * partSize, part * partSize + partSize + remaining));
                        } else {
                            text.add(element + part, elementForDivide.substring(part * partSize, part * partSize + partSize));
                        }
                    }
                }
            }
                command = scanner.nextLine();
            }
            /*for (String item : text) {
                for (int i = 1; i <= item.length()-1; i++) {
                    if (Character.isUpperCase(i)){
                        System.out.print(item + "");
                    }else {
                        System.out.print(item + " ");
                    }*/
        for (int i = 0; i < text.size(); i++) {
            System.out.print(text.get(i) + " ");
                }


            }
        }

