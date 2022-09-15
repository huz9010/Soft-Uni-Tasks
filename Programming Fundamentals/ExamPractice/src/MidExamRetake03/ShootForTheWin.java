package MidExamRetake03;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int shotTargetsCount = 0;

        while (!input.equals("End")){
            int currentTarget = Integer.parseInt(input);
            int shotTarget = 0;
            if (currentTarget < 0 || currentTarget > targets.length - 1 || targets[currentTarget] == -1){
                input = scanner.nextLine();
                continue;
            } else {
                shotTarget = targets[currentTarget];
                targets[currentTarget] = -1;
                shotTargetsCount++;
            }
            for (int i = 0; i < targets.length; i++) {
                if (targets[i] > - 1 && targets[i] > shotTarget){
                    targets[i] -= shotTarget;
                } else if (targets[i] > -1 && targets[i] <= shotTarget) {
                    targets[i] += shotTarget;
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargetsCount);
        for (int element : targets) {
            System.out.print(element + " ");
        }
    }
}
