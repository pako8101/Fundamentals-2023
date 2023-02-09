package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int capacityWagon = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];
            if (command.equals("Add")) {
                int second = Integer.parseInt(commandArr[1]);
                wagons.add(second);
            } else {
                int numOfPassengers = Integer.parseInt(commandArr[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int wagonsCount = wagons.get(i);
                    if (wagonsCount + numOfPassengers <= capacityWagon) {
                        wagons.add(i, wagonsCount + numOfPassengers);
                        wagons.remove(i + 1);
                        break;
                    }
                }

            }
            input = scanner.nextLine();
        }

        for (int item : wagons) {
            System.out.print(item + " ");
        }
    }
}
