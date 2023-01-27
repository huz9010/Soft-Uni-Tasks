import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] carData = scanner.nextLine().split("\\s+");

            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);
            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);
            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            cars.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile"))  {

            cars.stream().filter(car -> car.getCargo().getCargoType().equals(command)).filter(Main::checkTires).forEach(System.out::println);

        } else if (command.equals("flamable")) {

            cars.stream().filter(car -> car.getCargo().getCargoType().equals(command)).filter(Main::checkEngine).forEach(System.out::println);

        }
    }

    private static boolean checkTires(Car car) {
        return car.getTire().getTire1Pressure() < 1 || car.getTire().getTire2Pressure() < 1
                || car.getTire().getTire3Pressure() < 1 ||car.getTire().getTire4Pressure() < 1;
    }

    private static boolean checkEngine(Car car) {
        return car.getEngine().getEnginePower() > 250;
    }
}
