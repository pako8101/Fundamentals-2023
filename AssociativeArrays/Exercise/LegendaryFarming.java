package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new HashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();
        boolean isWIn = false;
        while (!isWIn) {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int index = 0; index < inputData.length; index ++) {
                if (index % 2 == 0) {
                    int quantity = Integer.parseInt(inputData[index]);
                    String material = inputData[index + 1].toLowerCase();
                    if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                        int currentQuantity = items.get(material);
                        items.put(material, currentQuantity + quantity);
                        if (items.get(material) >= 250) {
                            items.put(material, items.get(material) - 250);
                            if (material.equals("shards")) {
                                System.out.println("Shadowmourne obtain!");
                            } else if (material.equals("fragments")) {
                                System.out.println("Valanyr obtained!");
                            } else if (material.equals("motes")) {
                                System.out.println("Dragonwrath obtained!");
                            }
                            isWIn = true;
                            break;
                        }
                    } else {
                        if (!junk.containsKey(material)) {
                            junk.put(material, quantity);
                        }
                            int current = junk.get(material);
                            junk.put(material, current + quantity);
                        }
                    }
                    if (isWIn = false) {
                        break;
                    }
                }

                items.entrySet().stream()
                        .sorted((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> {
                            return o2.getValue().equals(o1.getValue()) ?
                                    o1.getKey().compareTo(o2.getKey())
                                    : o2.getValue().compareTo(o1.getValue());
                        }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

                for (Map.Entry<String, Integer> entry : junk.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());

                }
               /* } else {
                    junk.put(material, !junk.containsKey(material) ? quantity : junk.get(material) + quantity);
                }
            }
        }

        items.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }*/
              /*  }
                if (!junk.containsKey(material)) {
                    junk.put(material, quantity);
                } else {
                    int current = junk.get(material);
                    junk.put(material, current + quantity);
                }
            }

        }

        items.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junk.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }*/
            }
        }
    }
