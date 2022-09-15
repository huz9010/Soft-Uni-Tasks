package MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        switch (dataType){
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                getMax(num1, num2);
                break;

            case "char":
                char ch1 = scanner.nextLine().charAt(0);
                char ch2 = scanner.nextLine().charAt(0);
                getMax(ch1, ch2);
                break;

            case "string":
                String str1 = scanner.nextLine();
                String str2 = scanner.nextLine();
                getMax(str1, str2);
                break;
        }
    }

    public static void getMax(int num1, int num2)    {
        if (num1 > num2)    {
            System.out.println(num1);;
        }   else {
            System.out.println(num2);;
        }
    }

    public static void getMax(char ch1, char ch2) {
        if (ch1 > ch2) {
            System.out.println(ch1);
        } else {
            System.out.println(ch2);
        }

    }

        public static void getMax(String str1, String str2) {
            if (str1.compareTo(str2) > 0)   {
                System.out.println(str1);
            }   else {
                System.out.println(str2);
            }
        }
}
