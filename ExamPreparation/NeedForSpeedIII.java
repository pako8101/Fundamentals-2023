package ProgrammingFundamentalsWithJava2023.ExamPreparation;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCars = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < numberCars; i++) {
            String[] cars = scanner.nextLine().split("\\|");
            String kindCar = cars[0];
            int mileage = Integer.parseInt(cars[1]);
            int fuel = Integer.parseInt(cars[2]);

            carsMap.putIfAbsent(kindCar, new ArrayList<>());
            carsMap.get(kindCar).add(0, mileage);
            carsMap.get(kindCar).add(1, fuel);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String car = tokens[1];
            int mileage = carsMap.get(car).get(0);
            int fuel = carsMap.get(car).get(1);

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int consumedFuel = Integer.parseInt(tokens[3]);

                    if (fuel >= consumedFuel) {
                        if (carsMap.containsKey(car)) {
                            carsMap.get(car).set(0, mileage + distance);
                            carsMap.get(car).set(1, fuel - consumedFuel);
                            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                    car, distance, consumedFuel);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (mileage + distance >= 100000) {
                        System.out.printf("Time to sell the %s!%n", car);
                        carsMap.remove(car);
                    }
                    break;
                case "Refuel":
                    int fuelRefuel = Integer.parseInt(tokens[2]);
                    int totalFuel = fuel + fuelRefuel;
                    int diff = 0;
                    if (totalFuel > 75) {
                        diff = 75 - fuel;
                        totalFuel = 75;
                    } else {
                        diff = fuelRefuel;
                    }
                    carsMap.get(car).set(1, totalFuel);
                    System.out.printf("%s refueled with %d liters%n", car, diff);
                    break;
                case "Revert":
                    int km = Integer.parseInt(tokens[2]);
                    int totalMile = mileage - km;
                    if (totalMile < 10000) {
                        totalMile = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                    }
                    carsMap.get(car).set(0, totalMile);

                    break;
            }

            input = scanner.nextLine();
        }
        carsMap.forEach((key, value) ->
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                        key, value.get(0), value.get(1)));

       /* for (Map.Entry<String, List<Integer>> entry : carsMap.entrySet()){
            String car = entry.getKey();
            int mileage = entry.getValue().get(0);
            int fuel = entry.getValue().get(1);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                    car, mileage, fuel);*/

    }
}



