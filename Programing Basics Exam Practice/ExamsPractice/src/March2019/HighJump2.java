package March2019;

import java.util.Scanner;

public class HighJump2 {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int target = Integer.parseInt(scanner.nextLine());
            int firstTarget = target - 30;
            int jumpCount = 0;
            int fails = 0;
            boolean failed = false;

            while (!failed) {
                int jump = Integer.parseInt(scanner.nextLine());
                jumpCount++;

                if (jump <= firstTarget) {
                    fails++;
                    if (fails == 3) {
                        failed = true;
                    } else if (firstTarget >= target) {
                        break;
                    }
                }
                fails = 0;
                firstTarget += 5;

            }
            if (failed)    {
                System.out.printf("Tihomir failed at %dcm after %d jumps.", firstTarget, jumpCount);
            }   else {
                System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", firstTarget, jumpCount + 1);
            }
        }
    }

