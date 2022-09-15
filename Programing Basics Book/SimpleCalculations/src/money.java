import java.util.Scanner;

public class money {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //На първия ред – броят биткойни. Цяло число в интервала [0 … 20].
        //На втория ред – броят китайски юани.  Реално число в интервала [0.00 … 50
        //000.00].
        //На третия ред – комисионната. Реално число в интервала [0.00 … 5.00].

        //1 биткойн = 1168 лева.
        //1 китайски юан = 0.15 долара.
        //1 долар = 1.76 лева.
        //1 евро = 1.95 лева.

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double yuans = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());
        double commissionNum = commission / 100;

        double bitcoinToEuro = (bitcoins * 1168) / 1.95;
        double yuansToEuro = (yuans*0.15*1.76) / 1.95;

        double result = (bitcoinToEuro + yuansToEuro) - (bitcoinToEuro + yuansToEuro)*commissionNum;

        System.out.println(result);

    }
}
