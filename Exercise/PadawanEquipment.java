package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceOfSabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelt = Double.parseDouble(scanner.nextLine());
        double neededEquipment = 0.0;
        neededEquipment = priceOfSabers * (countStudents + Math.ceil(countStudents * 0.1)) +
                priceOfRobes * countStudents + priceOfBelt * (countStudents - Math.ceil(countStudents / 6));

        if (amount >= neededEquipment) {
            System.out.printf("The money is enough - " +
                    "it would cost %.2flv.\n", neededEquipment);
        } else {
            System.out.printf("George Lucas will need %.2flv more.\n",
                    Math.abs(amount - neededEquipment));
        }


    }
}
