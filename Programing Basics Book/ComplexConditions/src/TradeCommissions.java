import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine().toLowerCase();
        double sales = Double.parseDouble(scanner.nextLine());
        double commission = 0;

        if (city.equals("sofia")){
            if ((sales >= 0) && (sales <= 500)){
                commission = sales * 0.05;
            } else if ((sales > 500) && (sales <= 1000)){
                commission = sales * 0.07;
            } else if ((sales > 1000) && (sales <= 10000)){
                commission = sales * 0.08;
            } else if (sales > 10000){
                commission = sales * 0.12;
            }
        }   else if (city.equals("varna")){
            if ((sales >= 0) && (sales <= 500)){
                commission = sales * 0.045;
            } else if ((sales > 500) && (sales <= 1000)){
                commission = sales * 0.075;
            } else if ((sales > 1000) && (sales <= 10000)){
                commission = sales * 0.1;
            } else if (sales > 10000){
                commission = sales * 0.13;
            }
        } else if (city.equals("plovdiv")){
            if ((sales >= 0) && (sales <= 500)){
                commission = sales * 0.055;
            } else if ((sales > 500) && (sales <= 1000)){
                commission = sales * 0.08;
            } else if ((sales > 1000) && (sales <= 10000)){
                commission = sales * 0.12;
            } else if (sales > 10000){
                commission = sales * 0.145;
            }
        }
        if (commission <= 0){
            System.out.println("error");
        }   else {
            System.out.printf("%.2f", commission);
        }
    }
}
