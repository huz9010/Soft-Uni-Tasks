import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<Car> carsSet = new LinkedHashSet<>();

        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            String[] carInfo = scanner.nextLine().split("\\s+");
            car.setBrand(carInfo[0]);
            car.setModel(carInfo[1]);
            car.setHorsePower(Integer.parseInt(carInfo[2]));

            carsSet.add(car);
        }


        carsSet.forEach(e -> System.out.println(e.carInfo()));
    }
}
