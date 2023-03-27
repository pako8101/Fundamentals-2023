package ProgrammingFundamentalsFinalExamRetake02;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsNumber = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carMap = new HashMap<>();

        for (int i = 1; i <= carsNumber; i++) {
            String[] cars = scanner.nextLine().split("\\|");
            String carBrand = cars[0];
            int mileage = Integer.parseInt(cars[1]);
            int fuel = Integer.parseInt(cars[2]);
            carMap.putIfAbsent(carBrand, new ArrayList<>());
            carMap.get(carBrand).add(0, mileage);
            carMap.get(carBrand).add(1, fuel);
        }
        String input = scanner.next();
        while (!input.equals("Stop")) {
            String[] commands = input.split(" : ");
            String command = commands[0];
            String car = commands[1];
            int mileage = carMap.get(car).get(0);
            int fuel = carMap.get(car).get(1);
            switch (command) {
                case "Drive":
                    int distanceDrive = Integer.parseInt(commands[2]);
                    int driveFuel = Integer.parseInt(commands[3]);
                    if (distanceDrive + mileage >= 100000) {
                        System.out.println("Time to sell the %s!" + car);
                        carMap.remove(car);
                    }
                    if (driveFuel <= fuel) {
                        if (carMap.containsKey(car)) {
                            carMap.get(car).set(0, mileage + distanceDrive);
                            carMap.get(car).set(1, fuel + driveFuel);
                            System.out.printf("%s driven for %d kilometers." +
                                    " %d liters of fuel consumed.\n", car, distanceDrive, driveFuel);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");

                    }
                    break;
                case "Refuel":
                    int refFuel = Integer.parseInt(commands[2]);
                    int totalFuel = fuel + refFuel;
                    int diff = 0;
                    if (totalFuel > 75) {
                        diff = 75 - fuel;
                        totalFuel = 75;
                    } else {
                        diff = refFuel;
                    }
                    carMap.get(car).set(1,totalFuel);
                    System.out.printf("%s refueled with %d liters\n", car, diff);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    int totalMil = mileage - kilometers;
                    if (totalMil < 10000) {
                        totalMil = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, totalMil);
                    }
                    carMap.get(car).set(0, totalMil);

                    break;
            }

            input = scanner.nextLine();
        }
        carMap.forEach((key, value) ->
                System.out.printf("%s-> Mileage: %d kms, Fuel in the tank: %d lt.\n"
                        , key, value.get(0), value.get(1)));
    }


}

