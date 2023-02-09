package ProgrammingFundamentalsWithJava2023.Lists.Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int sumRemoved = 0;
        while (numbersList.size()>0){
            int index = Integer.parseInt(scanner.nextLine());
            if (isValid(index,numbersList)){
                int removedElement = numbersList.get(index);
                sumRemoved+=removedElement;
                numbersList.remove(index);
                modifyList(numbersList, removedElement);
            } else if (index<0) {
                int firstElement = numbersList.get(0);
                sumRemoved+=firstElement;
                numbersList.remove(0);

                int lastElement = numbersList.size()-1;
                numbersList.set(0,lastElement);
                modifyList(numbersList,firstElement);
            }else if (index> numbersList.size()-1) {
                int lastElement = numbersList.size()-1;
                sumRemoved+=lastElement;
                numbersList.remove(numbersList.size()-1);
                int firstElement = numbersList.get(0);
                numbersList.add(firstElement);
                modifyList(numbersList,lastElement);

            }
        }
        System.out.println(sumRemoved);
    }

    private static void modifyList(List<Integer> numbersList, int removedElement) {
        for (int i = 0; i <= numbersList.size()-1; i++) {
            int current = numbersList.get(i);
            if (current <= removedElement){
                current+= removedElement;
            }else {
                current -= removedElement;
            }
            numbersList.set(i, current);
        }
    }

    public static boolean isValid(int number, List<Integer>numbers){
        return number>=0 && number<= numbers.size()-1;
    }
}
