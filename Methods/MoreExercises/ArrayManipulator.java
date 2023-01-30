package ProgrammingFundamentalsWithJava2023.Methods.MoreExercises;

import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split("\\s+ ");
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("exchange")) {
                inputArray = getNewArray(inputArray, tokens[1]);
            } else if (tokens[0].equals("max")) {
                if (tokens[1].equals("even")) {
                    getMaxEven(inputArray);
                } else {
                    getMaxOdd(inputArray);
                }
            } else if (tokens[0].equals("min")) {
                if (tokens[1].equals("even")) {
                    getMinEven(inputArray);
                }
                getMinOdd(inputArray);
            } else if (tokens[0].equals("first")) {
                if (tokens[2].equals("even")){
                    findFirstEven(inputArray,tokens[1]);
                }else {
                    findFirstOdd(inputArray,tokens[1]);
                }
            } else if (tokens[0].equals("last")) {
                if (tokens[2].equals("even")){
                    findLastEven(inputArray, tokens[1]);
                }else {
                    findLastOdd(inputArray, tokens[0]);
                }
            }
            command = scanner.nextLine();
                }
                System.out.println("[");
        for (int i = 0; i <= inputArray.length-1 ; i++) {
            if (inputArray.length-1 ==i){
                System.out.println(inputArray[i]);
            }else {
                System.out.println(inputArray[i] + ", ");
            }
        }
        System.out.println("]");
            }

    private static void findLastOdd(String[] inputArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount> inputArray.length){
            System.out.println("Invalid count");
        }else {
            int countOdd = 0;
            for (int i = 0; i <= inputArray.length-1 ; i++) {
                int current = Integer.parseInt(inputArray[i]);
                if (current%2==1){
                    countOdd++;
                }
            }
            int[]array = new int[Math.min(countOdd,neededCount)];
            if (array.length>0){
                int index = 0;
                for (int i = inputArray.length-1; i >=0 ; i--) {
                    int current = Integer.parseInt(inputArray[i]);
                    if (current%2==1){
                        array[index]= current;
                        index++;
                        if (index> array.length-1){
                            break;
                        }
                    }
                }
                int[]reversedArray = new int[array.length];
                for (int i = 0; i <= reversedArray.length-1 ; i++) {
                    reversedArray[i]= array[array.length-(i+1)];
                }
                System.out.println("[");
                for (int i = 0; i <= reversedArray.length-1 ; i++) {
                    if (i == reversedArray.length-1){
                        System.out.println(reversedArray[i]);
                    }else {
                        System.out.println(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            }else {
                System.out.println("[]");
            }
        }
    }

    private static void findLastEven(String[] inputArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount> inputArray.length){
            System.out.println("Invalid count");
        }else {
            int countEven = 0;
            for (int i = 0; i <= inputArray.length-1 ; i++) {
                int current = Integer.parseInt(inputArray[i]);
                if (current%2==0){
                    countEven++;
                }
            }
            int[]array = new int[Math.min(countEven,neededCount)];
            if (array.length>0){
                int index = 0;
                for (int i = inputArray.length-1; i >=0 ; i--) {
                    int current = Integer.parseInt(inputArray[i]);
                    if (current%2==0){
                        array[index]= current;
                        index++;
                        if (index> array.length-1){
                            break;
                        }
                    }
                }
                int[]reversedArray = new int[array.length];
                for (int i = 0; i <= reversedArray.length-1 ; i++) {
                    reversedArray[i]= array[array.length-(i+1)];
                }
                System.out.println("[");
                for (int i = 0; i <= reversedArray.length-1 ; i++) {
                    if (i == reversedArray.length-1){
                        System.out.println(reversedArray[i]);
                    }else {
                        System.out.println(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            }else {
                System.out.println("[]");
            }
        }

    }

    private static void findFirstOdd(String[] inputArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount> inputArray.length){
            System.out.println("Invalid count");
        }else {
            int countOdd =0;
            for (int i = 0; i <= inputArray.length-1 ; i++) {
                int current = Integer.parseInt(inputArray[i]);
                if (current%2==1){
                    countOdd++;
                }

            }
            int[]array = new int[Math.min(countOdd, neededCount)];
            if (array.length>0){
                int index =0;
                for (int i = 0; i <=inputArray.length-1 ; i++) {
                    int current = Integer.parseInt(inputArray[i]);
                    if (current%2==1){
                        array[index]= current;
                        index++;
                        if (index> array.length-1){
                            break;
                        }
                    }
                }
                System.out.println("[");
                for (int i = 0; i <= array.length - 1 ; i++) {
                    if (i== array.length-1){
                        System.out.println(array[i]);
                    }else {
                        System.out.println(array[i] + ", ");
                    }
                }
                System.out.println("]");
            }else {
                System.out.println("[]");
            }
        }
    }

    private static void findFirstEven(String[] inputArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount> inputArray.length){
            System.out.println("Invalid count");
        }else {
            int countEven =0;
            for (int i = 0; i <= inputArray.length-1 ; i++) {
                int current = Integer.parseInt(inputArray[i]);
                if (current%2==0){
                    countEven++;
                }

            }
            int[]array = new int[Math.min(countEven, neededCount)];
            if (array.length>0){
                int index =0;
                for (int i = 0; i <=inputArray.length-1 ; i++) {
                    int current = Integer.parseInt(inputArray[i]);
                    if (current%2==0){
                        array[index]= current;
                        index++;
                        if (index> array.length-1){
                            break;
                        }
                    }
                }
                System.out.println("[");
                for (int i = 0; i <= array.length - 1 ; i++) {
                    if (i== array.length-1){
                        System.out.println(array[i]);
                    }else {
                        System.out.println(array[i] + ", ");
                    }
                }
                System.out.println("]");
            }else {
                System.out.println("[]");
            }
        }

    }

    private static void getMinOdd(String[] inputArray) {
        int minOdd = Integer.MAX_VALUE;
        int indexOfMinElement = -1;
        for (int i = 0; i <= inputArray.length-1 ; i++) {
            if (Integer.parseInt(inputArray[i])%2==1){
                if (Integer.parseInt(inputArray[i])<=minOdd){
                    minOdd = Integer.parseInt(inputArray[i]);
                    indexOfMinElement = i;
                }
            }
        }if (indexOfMinElement>-1){
            System.out.println(indexOfMinElement);
        }else {
            System.out.println("No matches");
        }
    }

    private static void getMinEven(String[] inputArray) {
        int minEven = Integer.MAX_VALUE;
        int indexOfMinElement = -1;
        for (int i = 0; i <= inputArray.length-1 ; i++) {
            if (Integer.parseInt(inputArray[i])%2==1){
                if (Integer.parseInt(inputArray[i])<=minEven){
                    minEven = Integer.parseInt(inputArray[i]);
                    indexOfMinElement = i;
                }
            }
        }if (indexOfMinElement>-1){
            System.out.println(indexOfMinElement);
        }else {
            System.out.println("No matches");
        }


    }

    private static void getMaxOdd(String[] inputArray) {
        int maxElement = Integer.MAX_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= inputArray.length -1 ; i++) {
            if (Integer.parseInt(inputArray[i]) %2 ==1){
                if (Integer.parseInt(inputArray[i])>= maxElement){
                    maxElement = Integer.parseInt(inputArray[i]);
                    indexOfMaxElement = i;
                }
            }

        }
        if (indexOfMaxElement>-1){
            System.out.println(indexOfMaxElement);
        }else {
            System.out.println("No matches");
        }
    }

    private static void getMaxEven(String[] inputArray) {
        int maxElement = Integer.MIN_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= inputArray.length - 1; i++) {
            if (Integer.parseInt(inputArray[i]) % 2 == 0) {
                if (Integer.parseInt(inputArray[i]) >= maxElement) {
                    maxElement = Integer.parseInt(inputArray[i]);
                    indexOfMaxElement = i;
                }
            }
        }
        if (indexOfMaxElement>-1){
            System.out.println(indexOfMaxElement);
        }else {
            System.out.println("No matches");
        }
    }


    private static String[] getNewArray(String[] inputArray, String token) {
        int index= Integer.parseInt(token);
        String[]newArray = new String[inputArray.length];
        if (index<0 || index>=inputArray.length){
            System.out.println("Invalid index");
            return  inputArray;
        }else {
            int x = 0;
            for (int start = index + 1; start < inputArray.length ; start++) {
                newArray[x]= inputArray[start];
                x++;
            }
            for (int end = 0; end <=index ; end++) {
                newArray[x]=inputArray[end];
                x++;
            }
        }return newArray;
    }
}

