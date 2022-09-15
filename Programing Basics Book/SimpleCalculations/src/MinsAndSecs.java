import java.util.Scanner;

public class MinsAndSecs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sec1 = Integer.parseInt(scanner.nextLine());
        int sec2 = Integer.parseInt(scanner.nextLine());
        int sec3 = Integer.parseInt(scanner.nextLine());


        int secsum = sec1 + sec2 + sec3;


        if (secsum >= 0 && secsum < 60 && secsum < 10){
            System.out.println("0:0" + secsum);
        } else if (secsum < 60 && secsum > 10) {
            System.out.println("0:" + secsum);
        } else if (secsum >= 60 && secsum < 120 && (secsum-60) < 10) {
            System.out.println("1:0" + (secsum - 60));
        } else if (secsum >= 60 && secsum < 120 && (secsum - 60) > 10) {
            System.out.println("1:" + (secsum - 60));
        } else if (secsum >=120 && (secsum - 120) < 10) {
            System.out.println("2:0" + (secsum - 120));
        } else if (secsum >= 120 && secsum <= 179 && (secsum - 120) > 10) {
            System.out.println("2:" + (secsum - 120));
        }

    }
}
