package LoopsExercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;

        for (int i = 1; i <= groups ; i++) {

            int groupMembers = Integer.parseInt(scanner.nextLine());

                if (groupMembers <= 5)  {
                    musala += groupMembers;
                } else if (groupMembers <= 12) {
                    monblan += groupMembers;
                } else if (groupMembers <= 25) {
                    kilimandjaro += groupMembers;
                } else if (groupMembers <= 40) {
                    k2 += groupMembers;
                }   else {
                    everest += groupMembers;
                }
        }
        int allMembers = musala + monblan + kilimandjaro + k2 + everest;

        double p1 = musala * 100.0 / allMembers;
        double p2 = monblan * 100.0 / allMembers;
        double p3 = kilimandjaro * 100.0 / allMembers;
        double p4 = k2 * 100.0 / allMembers;
        double p5 = everest * 100.0 / allMembers;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n", p1, p2, p3, p4, p5);
    }
}
