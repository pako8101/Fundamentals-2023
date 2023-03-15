package ProgrammingFundamentalsWithJava2023.RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        List<String> racersNames = Arrays.stream(names
                        .split(", "))
                .collect(Collectors.toList());
        //масив
        //лист
        Map<String, Integer> racerDistance = new LinkedHashMap<>();
        racersNames.forEach(name -> racerDistance.putIfAbsent(name, 0));
        String regexLetter = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetter);//шаблон за буквите
        String regexDigit = "[0-9]";
        Pattern patternDigit = Pattern.compile(regexDigit);//шаблон за цифри
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            //име на съзтезателя
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetter = patternLetter.matcher(input);
            while (matcherLetter.find()) {
                nameBuilder.append(matcherLetter);
            }
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }
            String racerName = nameBuilder.toString();
            if (racerDistance.containsKey(racerName)) {//играча в първонач,списък
                int currentDistance = racerDistance.get(racerName);//текуща дистанция избягана от играча
                racerDistance.put(racerName, currentDistance + distance);
            }
            input = scanner.nextLine();
        }
        List<String>nameOfFirstThree = new LinkedList<>();
                racerDistance.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).limit(3).forEach(e -> nameOfFirstThree.add(e.getKey()));

        System.out.println("1st place: "+ nameOfFirstThree.get(0));
        System.out.println("2nd place: "+ nameOfFirstThree.get(1));
        System.out.println("3rd place: "+ nameOfFirstThree.get(2));
    }
        //без сортировка
       /* int count = 1;
        for (Map.Entry<String, Integer> pair : racerDistance.entrySet()) {
            if (count == 1) {
                System.out.println("1st place: " + pair.getKey());
                count++;
            } else if (count == 2) {
                System.out.println("2nd place: " + pair.getKey());
                count++;
            } else if (count == 3) {
                System.out.println("3rd place: " + pair.getKey());
                break;
            }*/
        }

