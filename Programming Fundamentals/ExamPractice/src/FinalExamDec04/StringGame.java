package FinalExamDec04;

import java.util.Scanner;

public class StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done"))   {
            String command = input.split(" ")[0];

            switch (command)    {
                case "Change":
                    char oldChar = input.split(" ")[1].charAt(0);
                    char newChar = input.split(" ")[2].charAt(0);
                    inputString = inputString.replace(oldChar, newChar);
                    System.out.println(inputString);
                    break;
                case "Includes":
                    String substring = input.split(" ")[1];
                    if (inputString.contains(substring))    {
                        System.out.println("True");
                    }   else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endString = input.split(" ")[1];
                    if (inputString.endsWith(endString))    {
                        System.out.println("True");
                    }   else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    inputString = inputString.toUpperCase();
                    System.out.println(inputString);
                    break;
                case "FindIndex":
                    char charToCheck = input.split(" ")[1].charAt(0);
                    int indexOfChar = inputString.indexOf(charToCheck);
                    System.out.println(indexOfChar);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int count = Integer.parseInt(input.split(" ")[2]);

                    StringBuilder removedChars = new StringBuilder();
                    StringBuilder resultString = new StringBuilder(inputString);

                    while (startIndex != 0){
                        int i = 0;
                        removedChars.append(resultString.charAt(i));
                        resultString.deleteCharAt(i);
                        startIndex--;
                    }

                    removedChars.append(resultString.substring((count)));
                    resultString.delete(count, resultString.length());

                    inputString = resultString.toString();
                    System.out.println(inputString);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
