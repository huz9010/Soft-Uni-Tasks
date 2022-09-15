import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int busWeight =0;
        int truckWeight = 0;
        int trainWeight = 0;

        double pricePerTone = 0;
        double busPercent = 0;
        double truckPercent = 0;
        double trainPercent =0;

        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(scanner.nextLine());

            if (weight <= 3){
                busWeight += weight;
            } else if (weight <= 11) {
                truckWeight += weight;
            }   else {
                trainWeight += weight;
            }
        }

        double totalWeight = busWeight + truckWeight + trainWeight;
        pricePerTone = (busWeight * 200 + truckWeight * 175 + trainWeight * 120) / totalWeight;
        busPercent = busWeight * 100 / totalWeight;
        truckPercent = truckWeight * 100 / totalWeight;
        trainPercent = trainWeight * 100 / totalWeight;

        System.out.printf("%.2f%n%.2f%%%n%.2f%%%n%.2f%%", pricePerTone, busPercent, truckPercent, trainPercent);
    }
}
