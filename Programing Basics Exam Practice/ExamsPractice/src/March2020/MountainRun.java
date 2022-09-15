package March2020;

import java.util.Scanner;

public class MountainRun {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            double record = Double.parseDouble(scanner.nextLine());
            double distance = Double.parseDouble(scanner.nextLine());
            double secsPerM = Double.parseDouble(scanner.nextLine());

            double delay = Math.floor(distance / 50) * 30.0;

            double totalTime = distance * secsPerM + delay;

            if (totalTime < record){
                System.out.printf("Yes! The new record is %.2f seconds.", totalTime);
            }   else {
                System.out.printf("No! He was %.2f seconds slower.", totalTime - record);
            }
        }
    }


