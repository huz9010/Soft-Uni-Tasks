package March2019;

import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());
        int firstTarget = target - 30;
        int jumpCount = 0;
        int fails = 0;


        while (firstTarget <= target) {
            int jump = Integer.parseInt(scanner.nextLine());
            jumpCount++;

          if (jump <= firstTarget)  {
              fails++;
          } else {
              firstTarget += 5;
              fails = 0;
          }


          if (fails == 3)   {
              break;
          }
        }
        if (fails == 3)    {
            System.out.printf("Tihomir failed at %dcm after %d jumps.", firstTarget, jumpCount);
        }   else {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", target, jumpCount);
        }
    }
}
