package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> registeredUser = new LinkedHashMap<>();

        for (int i = 1; i <= numberCommands; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            String command = inputLine[0];
            String username = inputLine[1];
            if (command.equals("register")) {
                String licensePlateNumber = inputLine[2];
                if (registeredUser.containsValue(username)) {
                    System.out.println("ERROR: already registered with plate number " + licensePlateNumber);
                } else {
                    registeredUser.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n",
                            username, licensePlateNumber);
                }
            } else if (command.equals("unregister")) {
                if (!registeredUser.containsKey(username)) {
                    System.out.println("ERROR: user " + username + " not found");
                } else {
                    registeredUser.remove(username);
                    System.out.println(username + " unregistered successfully");
                }
            }
        }

        for (String username : registeredUser.keySet()) {
            System.out.println(username + " => " + registeredUser.get(username));
        }
    }
}

