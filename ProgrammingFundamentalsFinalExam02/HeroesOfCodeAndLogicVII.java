package ProgrammingFundamentalsFinalExam02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, Integer[]> mapPoints = new HashMap<>();
        for (int i = 0; i < numOfHeroes; i++) {
            String[] points = scanner.nextLine().split(" ");
            String heroName = points[0];
            int hp = Integer.parseInt(points[1]);
            int mp = Integer.parseInt(points[2]);
            mapPoints.putIfAbsent(heroName, new Integer[2]);
            mapPoints.get(heroName)[0] = hp;
            mapPoints.get(heroName)[1] = mp;
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] actions = input.split(" - ");
            String command = actions[0];
            String name = actions[1];
            if (command.equals("CastSpell")) {
                int mpNeeded = Integer.parseInt(actions[2]);
                String spellName = actions[3];
                int currentMp = mapPoints.get(name)[1];
                if (currentMp >= mpNeeded) {
                    currentMp -= mpNeeded;
                    mapPoints.get(name)[1] = currentMp;
                    System.out.printf("%s has successfully cast %s " +
                            "and now has %d MP!\n", name, spellName, currentMp);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                }
            }
            if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(actions[2]);
                String attacker = actions[3];
                int currentHp = mapPoints.get(name)[0];
                currentHp -= damage;
                mapPoints.get(name)[0] = currentHp;
                if (mapPoints.get(name)[0] > 0) {
                    System.out.printf("%s was hit for %d HP by %s " +
                            "and now has %d HP left!\n", name, damage, attacker, currentHp);
                } else {
                    System.out.printf("%s has been killed by %s!%n", name, attacker);
                    mapPoints.remove(name);
                }
            }
            if (command.equals("Recharge")) {
                int amountRe = Integer.parseInt(actions[2]);
                int currentMp = mapPoints.get(name)[1];
                if (currentMp + amountRe > 200) {
                    currentMp = 200 - currentMp;
                    System.out.printf("%s recharged for %d MP!\n", name, currentMp);
                    currentMp = 200;
                    mapPoints.get(name)[1] = 200;
                } else {
                    System.out.printf("%s recharged for %d MP!\n", name, amountRe);
                    currentMp += amountRe;
                    mapPoints.get(name)[1] = currentMp;
                }

            }
            if (command.equals("Heal")) {
                int amountHeal = Integer.parseInt(actions[2]);
                int currentHp = mapPoints.get(name)[0];

                if (currentHp + amountHeal > 100) {
                    currentHp = 100 - currentHp;
                    System.out.printf("%s healed for %d HP!\n", name, currentHp);
                    currentHp = 100;
                    mapPoints.get(name)[0] = 100;
                } else {
                    System.out.printf("%s healed for %d HP!\n", name, amountHeal);
                    currentHp += amountHeal;
                    mapPoints.get(name)[0] = currentHp;
                }
            }
            input = scanner.nextLine();
        }
        mapPoints.entrySet().stream().
                sorted((a, b) -> Integer.compare(b.getValue()[1], a.getValue()[0]))
                .forEach(entry ->
                        System.out.printf("%s%nHP: %d%nMP: %d%n",
                                entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
    }
}
