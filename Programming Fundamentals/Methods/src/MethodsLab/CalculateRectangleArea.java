package MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int area = rectangleArea(width, length);

        System.out.println(area);
    }

    public static Integer rectangleArea(int a, int b)   {
        return a * b;
    }
}
