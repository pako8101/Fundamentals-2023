package ProgrammingFundamentalsFinalExam01;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();

          /* String[]arr = scanner.nextLine().split("::");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                list.add(arr[i]);*/
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commands = input.split(":");
            String command = commands[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    String city = commands[2];
                    StringBuilder builder = new StringBuilder(stops);
                    if (isValidIndex(stops, index)) {
                       /* builder.insert(index, city);
                        stops = builder.toString();*/
                        stops= stops.substring(0,index) + city + stops.substring(index);
                    }
                    System.out.println(stops);
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    StringBuilder strBuilder = new StringBuilder(stops);
                    if (isValidIndex(stops, startIndex) && isValidIndex(stops, endIndex)) {
                        strBuilder.delete(startIndex, endIndex);
                        stops = strBuilder.toString();
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldStr = commands[1];
                    String newStr = commands[2];
                    stops = stops.replace(oldStr, newStr);
                    System.out.println(stops);
                    break;

            }
            input = scanner.nextLine();

        }
        System.out.printf("Ready for world tour! Planned stops: %s\n", stops);


    }

    private static boolean isValidIndex(String string, int targetIndex) {
        return targetIndex >= 0 && targetIndex < string.length();
    }
}



