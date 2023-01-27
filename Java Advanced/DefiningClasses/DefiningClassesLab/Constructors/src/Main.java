import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<Car> carsSet = new LinkedHashSet<>();

        for (int i = 0; i < carCount; i++) {

            String[] carInfo = scanner.nextLine().split("\\s+");

            if (carInfo.length == 1)    {
                Car car = new Car(carInfo[0]);
                carsSet.add(car);
            } else if (carInfo.length == 2) {
                Car car = new Car(carInfo[0], carInfo[1]);
                carsSet.add(car);
            }   else {
                Car car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
                carsSet.add(car);
            }
        }
        carsSet.forEach(e -> System.out.println(e.carInfo()));
    }
}
