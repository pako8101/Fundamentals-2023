package ProgrammingFundamentalsRetakeExamPart210January2019;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .collect(Collectors.toList());
        List<String> songs = Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .collect(Collectors.toList());
        Map<String, Set<String>> awards = new LinkedHashMap<>();

        String command;
        while (!"dawn".equals(command = scanner.nextLine())) {
            String[] performance = command.split(",\\s+");
            String participant = performance[0];
            String song = performance[1];
            String award = performance[2];

            if (participants.contains(participant) && songs.contains(song)) {
                awards.putIfAbsent(participant, new HashSet<>());
                awards.get(participant).add(award);
            }

        }if (awards.isEmpty()) {
            System.out.println("No awards");
        }else {
            awards.entrySet().stream()
                    .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                    .forEach(entry -> {
                        String participant = entry.getKey();
                        Set<String> printAwards = entry.getValue();
                        if (!printAwards.isEmpty()) {

                            System.out.printf("%s: %d awards%n", participant, printAwards.size());
                            printAwards.stream()
                                    .sorted()
                                    .forEach(award -> System.out.printf("--%s%n", award));
                        }
                    });

        }

        }
    }

