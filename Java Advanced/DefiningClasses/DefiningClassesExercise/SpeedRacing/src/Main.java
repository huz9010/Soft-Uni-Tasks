import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        while (carCount-- > 0)  {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuel = Double.parseDouble(carData[1]);
            double fuelConsumption = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuel, fuelConsumption);
            cars.add(car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String carToDrive = input.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(input.split("\\s+")[2]);

            Car currentCar = cars.stream().filter(e -> e.getModel().equals(carToDrive)).findFirst().get();
            currentCar.drive(kmToDrive);

            input = scanner.nextLine();
        }

        cars.forEach(System.out::println);
    }
}
