package jediGalaxy;

import java.util.Arrays;

public class Player {

    long starsCollected;
    int row;
    int col;

    public Player() {
        this.starsCollected = 0;
    }

    public void move(int[][] field) {
        while (row >= 0 && col < field[0].length) {
            if (isValidIndex(row, col, field)) {
                starsCollected += field[row][col];
            }
            row--;
            col++;
        }
    }

    public long getStarsCollected() {
        return starsCollected;
    }

    public void setPosition(String input) {
        int[] position = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        this.row = position[0];
        this.col = position[1];
    }

    private boolean isValidIndex(int r, int c, int[][] field)  {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}
