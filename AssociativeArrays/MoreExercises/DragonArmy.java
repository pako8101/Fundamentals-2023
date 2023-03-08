package ProgrammingFundamentalsWithJava2023.AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    private static final int DEFAULT_DMG = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, int[]>> dragonsMap = new LinkedHashMap<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++) {
            String[] dragons = scanner.nextLine().split(" ");
            String type = dragons[0];
            String name = dragons[1];
            int damage = dragons[2].equals("null") ? DEFAULT_DMG: Integer.parseInt(dragons[2]);
            int health = dragons[3].equals("null") ? DEFAULT_HEALTH: Integer.parseInt(dragons[3]);
            int armor = dragons[4].equals("null") ? DEFAULT_ARMOR: Integer.parseInt(dragons[4]);
            dragonsMap.putIfAbsent(type, new TreeMap<>());
            if (!dragonsMap.get(type).containsKey(name)) {
                dragonsMap.get(type).put(name, new int[3]);
            }
            dragonsMap.get(type).get(name)[0] = damage;
            dragonsMap.get(type).get(name)[1] = health;
            dragonsMap.get(type).get(name)[2] = armor;
        }
        for (Map.Entry<String,TreeMap<String,int[]>> typeInfo: dragonsMap.entrySet()){
            double[] average = calcAverage(typeInfo.getValue());
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    typeInfo.getKey(), average[0], average[1],average[2]);
            for (Map.Entry<String,int[]> dragonInfo: typeInfo.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragonInfo.getKey(),
                        dragonInfo.getValue()[0],
                        dragonInfo.getValue()[1],
                        dragonInfo.getValue()[2]);

            }
        }
    }
    private static double[] calcAverage(TreeMap<String, int[]>map){
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmor = 0;
        for (Map.Entry<String,int[]> entry: map.entrySet()) {
            totalDamage+=entry.getValue()[0];
            totalHealth+=entry.getValue()[1];
            totalArmor+=entry.getValue()[2];
        }return new double[]{
                1.0 * totalDamage/map.size(),
                1.0 * totalHealth/map.size(),
                1.0 * totalArmor/ map.size()
        };
    }
}
