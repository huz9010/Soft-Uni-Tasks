package jediGalaxy;

import java.util.Arrays;

public class EvilPower {

    int row;
    int col;

    public EvilPower() {
    }

    public void move(int[][] field)  {
        while (row >= 0 && col >= 0) {
            if (isValidIndex(row, col, field)) {
                field[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    public void setPosition(String input)   {
        int[] position = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        this.row = position[0];
        this.col = position[1];
    }

    private boolean isValidIndex(int r, int c, int[][] field)  {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}
