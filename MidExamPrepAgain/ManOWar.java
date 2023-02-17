package ProgrammingFundamentalsWithJava2023.MidExamPreparation.MidExamPrepAgain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxHealth = Integer.parseInt(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Retire")) {
                break;
            }
            String[] commands = input.split("\\s+");
            String command = commands[0];
            if (command.equals("Fire")) {
                int fireIndex = Integer.parseInt(commands[1]);
                int fireDamage = Integer.parseInt(commands[2]);
                if (isValidIndex(warShip, fireIndex)) {
                    int indexToDamage = warShip.get(fireIndex);
                    /* int indexAfterDamage = indexToDamage - damage;*/
                   indexToDamage -= fireDamage;
                    if (indexToDamage <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            } else if (command.equals("Defend")) {
                int startIndexDef = Integer.parseInt(commands[1]);
                int endIndexDef = Integer.parseInt(commands[2]);
                int damageDef = Integer.parseInt(commands[3]);
                if (isValidIndex(pirateShip, startIndexDef) && isValidIndex(pirateShip, endIndexDef)) {
                    for (int j = startIndexDef; j <= endIndexDef; j++) {
                        int defIndex = pirateShip.get(j);
                        defIndex -= damageDef;
                        if (defIndex <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }
            } else if (command.equals("Repair")) {

                int repairIndex = Integer.parseInt(commands[1]);
                int healthRepair = Integer.parseInt(commands[2]);
                if (isValidIndex(pirateShip, repairIndex)) {
                    int toRepairIndex = pirateShip.get(repairIndex);
                    toRepairIndex = Math.min(healthRepair + toRepairIndex, maxHealth);

                }
            } else if (command.equals("Status")) {
                int pirateSectionNEedRepair = 0;
                for (int section : pirateShip) {
                    if (section < maxHealth * 0.2) {
                        pirateSectionNEedRepair++;
                    }
                }
                System.out.printf("%d sections need repair.\n", pirateSectionNEedRepair);
            }
        }
            int pirateSum = 0;
            for (int pirateSecSum : pirateShip) {
                pirateSum += pirateSecSum;
            }
            System.out.printf("Pirate ship status: %d\n", pirateSum);
            int warSum = 0;
            for (int warSecSum : warShip) {
                warSum += warSecSum;
            }
            System.out.printf("Warship status: %d\n", warSum);
        }


    private static boolean isValidIndex(List<Integer> list, int targetIndex) {
        return targetIndex >= 0 && targetIndex < list.size();
    }
}
