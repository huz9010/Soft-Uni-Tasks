package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    array = exchangeArray(index, array);
                    break;
                case "max":
                    String evenOdd = command[1];
                    maxEvenOrOdd(evenOdd, array);
                    break;
                case "min":
                    String oddEven = command[1];
                    minEvenOrOdd(oddEven, array);
                    break;
                case "first":
                    int indexCount = Integer.parseInt(command[1]);
                    String evenOrOdd = command[2];
                    firstCountEvenOdd(indexCount, evenOrOdd, array);
                    break;
                case "last":
                    int indexCountLast = Integer.parseInt(command[1]);
                    String evenOrOddLast = command[2];
                    lastCountEvenOdd(indexCountLast, evenOrOddLast, array);
            }
            input = scanner.nextLine();
        }
        if (array.length == 0){
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[array.length - 1]);
            System.out.print("]");
        }
    }

    public static int[] exchangeArray(int a, int[] array) {
        int[] exchangedArray = new int[array.length];
        if (a > array.length - 1 || a < 0) {
            System.out.println("Invalid index");
            return array;
        } else {
            int j = 0;
            for (int i = a + 1; i < array.length; i++) {
                exchangedArray[j] = array[i];
                j++;
            }
            for (int i = 0; i <= a; i++) {
                exchangedArray[j] = array[i];
                j++;
                if (j == array.length) {
                    break;
                }
            }
            return exchangedArray;
        }
    }

    public static void maxEvenOrOdd(String str, int[] array) {
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        switch (str) {
            case "even":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 == 0) {
                        if (array[i] >= max) {
                            max = array[i];
                            maxIndex = i;
                        }
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 != 0) {
                        if (array[i] >= max) {
                            max = array[i];
                            maxIndex = i;
                        }
                    }
                }
                break;
        }
        if (maxIndex == Integer.MIN_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(maxIndex);
        }
    }

    public static void minEvenOrOdd(String str, int[] array) {
        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        switch (str) {
            case "even":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 == 0) {
                        if (array[i] <= min) {
                            min = array[i];
                            minIndex = i;
                        }
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 != 0) {
                        if (array[i] <= min) {
                            min = array[i];
                            minIndex = i;
                        }
                    }
                }
                break;
        }
        if (minIndex == Integer.MAX_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(minIndex);
        }
    }

    public static void firstCountEvenOdd(int count, String str, int[] array) {
        if (count > array.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            int[] resultArray = new int[count];
            int counter = 0;
            switch (str) {
                case "even":
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] % 2 == 0) {
                            resultArray[counter] = array[i];
                            counter++;
                            if (counter >= resultArray.length) {
                                break;
                            }
                        }
                    }
                    break;
                case "odd":

                    for (int i = 0; i < array.length; i++) {
                        if (array[i] % 2 != 0) {
                            resultArray[counter] = array[i];
                            counter++;
                            if (counter >= resultArray.length) {
                                break;
                            }
                        }
                    }
                    break;
            }
            if (counter == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int i = 0; i < counter - 1; i++) {
                    System.out.print(resultArray[i] + ", ");
                }
                System.out.print(resultArray[counter - 1]);
                System.out.print("]");
                System.out.println();
            }
        }
    }

    public static void lastCountEvenOdd(int count, String str, int[] array) {
        if (count > array.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            int[] resultArray = new int[array.length];
            int counter = 0;
            switch (str) {
                case "even":
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] % 2 == 0) {
                            resultArray[counter] = array[i];
                            counter++;
                            if (counter >= resultArray.length) {
                                break;
                            }
                        }
                    }
                    break;
                case "odd":

                    for (int i = 0; i < array.length; i++) {
                        if (array[i] % 2 != 0) {
                            resultArray[counter] = array[i];
                            counter++;
                            if (counter >= resultArray.length) {
                                break;
                            }
                        }
                    }
                    break;
            }
            int[] finalArray = new int[counter];
            for (int i = 0; i < finalArray.length; i++) {
                finalArray[i] = resultArray[i];
            }
            if (counter == 0) {
                System.out.println("[]");
            } else if (count >= counter){
                    System.out.print("[");
                    for (int i = 0; i < counter - 1; i++) {
                        System.out.print(finalArray[i] + ", ");
                    }
                    System.out.print(finalArray[counter - 1]);
                    System.out.print("]");
                    System.out.println();

                }   else {
                    int startIndex = finalArray.length - count;
                    System.out.print("[");
                    for (int i = startIndex; i < finalArray.length - 1; i++) {
                        System.out.print(finalArray[i] + ", ");
                    }
                    System.out.print(resultArray[finalArray.length - 1]);
                    System.out.print("]");
                    System.out.println();
                }
        }
    }
}