package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Galaxy {

    private int[][] field;

    public Galaxy(Scanner scanner) {
        int[] position = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = position[0];
        int cols = position[1];
        int counter = 0;
        field = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                field[r][c] = counter;
                counter++;
            }
        }
    }

    public int[][] getField() {
        return field;
    }
}
