package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        String[] arrStrings = scanner.nextLine().split(" ");
        int bombNum = Integer.parseInt(arrStrings[0]);
        int power = Integer.parseInt(arrStrings[1]);

        while (numbersList.contains(bombNum)){
            int index = numbersList.indexOf(bombNum);

            int leftIndex = index - power;
            int rightIndex = index + power;
            if (leftIndex<0){
                leftIndex=0;
            }
            if (rightIndex>=numbersList.size()){
                rightIndex = numbersList.size()-1;
            }
            numbersList.subList(leftIndex,rightIndex + 1).clear();

        }
        int sum = 0;
        for (int i :numbersList) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
