package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = "";
        for (int position = username.length() - 1; position >= 0; position--) {
            int currentSymbol = username.charAt(position);
            password += currentSymbol;
        }
        String enterPass = scanner.nextLine();
        int count = 0;
        while (!enterPass.equals(password)) {
            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            enterPass = scanner.nextLine();
        }
        if (enterPass.equals(password)) {
            System.out.print("User " + username + " logged in.");
        }




        /*String password = scanner.nextLine();

        int tries = 0;

        while (tries < 4) {
            String userName = scanner.nextLine();
            if (userName.equals(new StringBuilder(password).reverse().toString())) {
                System.out.println("User " + password + " logged in.");
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
                tries++;
                if (tries == 4) {
                    System.out.println("User " + password + " blocked!");
                }
            }

        }*/
    }
}

