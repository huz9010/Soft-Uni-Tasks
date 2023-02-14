import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int startRow = 0;
        int endRow = rows;
        int startCol = 0;
        int endCol = cols;

        while (startRow < endRow && startCol < endCol)  {

            for (int i = startCol; i < endCol; ++i) {
                System.out.print(matrix[startRow][i] + " ");
            }
            startRow++;

            for (int i = startRow; i < endRow; ++i) {
                System.out.print(matrix[i][endCol - 1] + " ");
            }
            endCol--;

            if (startRow < endRow)  {
                for (int i = endCol - 1; i >= startCol; i--) {
                    System.out.print(matrix[endRow - 1][i] + " ");
                }
                endRow--;
            }

            if (startCol < endCol)  {
                for (int i = endRow - 1; i >= startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
                startCol++;
            }
        }
    }
}
