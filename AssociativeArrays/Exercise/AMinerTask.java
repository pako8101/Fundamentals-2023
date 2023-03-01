package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = " ";
        Map<String, Integer> miner = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            input = scanner.nextLine();
            if (!input.equals("stop")) {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (!miner.containsKey(input)) {
                    miner.put(input, quantity);
                } else {
                    int element = miner.get(input);
                    miner.put(input, element += quantity);
                }
            }
        }

            miner.entrySet().forEach(entry ->
                    System.out.println(entry.getKey() + " -> " + entry.getValue()));
            {

            }
        }
    }

