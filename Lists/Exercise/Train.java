package ProgrammingFundamentalsWithJava2023.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

            String lineInput = scanner.nextLine();
            while (!lineInput.equals("end")) {
                String[] commandArr = lineInput.split(" ");
                String command = commandArr[0];
                if (command.equals("Add")) {
                    int wagon = Integer.parseInt(commandArr[1]);
                    wagonsList.add(wagon);
                } else {
                    int wagonToSum = Integer.parseInt(commandArr[0]);
                    for (int i = 0; i < wagonsList.size(); i++) {
                        int countPassengers = wagonsList.get(i);
                        if (wagonToSum + countPassengers <= maxCapacity) {
                            wagonsList.add(i, wagonToSum + countPassengers);
                            wagonsList.remove(i + 1);
                            break;
                        }

                    }
                }

                lineInput = scanner.nextLine();
            }
            for (int item: wagonsList) {
                System.out.print(item + " ");
            }
        }
    }
