package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Map<String, LinkedHashMap<String, Integer>> store = new LinkedHashMap<>();
        while (!"Once upon a time".equals(input = scanner.nextLine())) {
            String[] data = input.split(" <:> ");
            String dwarfName = data[0];
            String color = data[1];
            int dwarfPhysics = Integer.parseInt(data[2]);
            store.putIfAbsent(dwarfName, new LinkedHashMap<>());
            store.get(dwarfName).putIfAbsent(color, dwarfPhysics);

            if (store.get(dwarfName).get(color) < dwarfPhysics) {
                store.get(dwarfName).put(color, dwarfPhysics);
            }
        }
        Map<String, Integer> hatMap = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : store.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                hatMap.put(entry.getKey() + " " + subEntry.getKey() + " "
                        + entry.getValue().size(), subEntry.getValue());
            }
        }

        hatMap.entrySet().stream()
                .sorted((a, b) -> {
                    int sort = Integer.compare(b.getValue(), a.getValue());
                    if (sort == 0) {
                        String[] color1 = a.getKey().split(" ");
                        String[] color2 = b.getKey().split(" ");

                        sort = color1[2].compareTo(color2[2]);

                    }
                    return sort;
                }).forEach(pair -> {
                    String[] print = pair.getKey().split(" ");
                    System.out.printf("(%s) %s <-> %d%n", print[1], print[0], pair.getValue());
                });
//            List<String> sameDwarf = new ArrayList<>();
//            hatMap.entrySet().stream().allMatch
//                    (stringIntegerEntry -> hatMap.containsKey(color));
//            for (Map.Entry<String,LinkedHashMap<String,Integer>> entry: store.entrySet()){
//                LinkedHashMap<String,Integer> hatMaps = store.get(dwarfName);
//                System.out.printf("(%s) %n", entry.getValue());
//                hatMaps.entrySet().stream().forEach
//                        (e -> System.out.printf("%s <-> %d", entry.getKey(),entry.getValue()));
//

    }

}


