import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineCount = Integer.parseInt(scanner.nextLine());

        HashMap<String, Engine> engines = new HashMap<>();
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        while (engineCount-- > 0)   {
            String[] engineData = scanner.nextLine().split("\\s+");

            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            Engine engine = null;

            switch (engineData.length)  {
                case 2:
                    engine = new Engine(model,power);
                    break;
                case 3:
                    if (Character.isDigit(engineData[2].charAt(0))) {
                        engine = new Engine(model, power, Integer.parseInt(engineData[2]));
                    }   else {
                        engine = new Engine(model, power, engineData[2]);
                    }
                    break;
                case 4:
                    engine = new Engine(model, power, Integer.parseInt(engineData[2]), engineData[3]);
                    break;
            }

            engines.put(model, engine);
        }

        int carCount = Integer.parseInt(scanner.nextLine());

        while (carCount-- > 0)  {
            String[] carData = scanner.nextLine().split("\\s+");

            String model = carData[0];
            String engine = carData[1];

            Car car = null;

            switch (carData.length)  {
                case 2:
                    car = new Car(model);
                    break;
                case 3:
                    if (Character.isDigit(carData[2].charAt(0))) {
                        car = new Car(model, Integer.parseInt(carData[2]));
                    }   else {
                        car = new Car(model, carData[2]);
                    }
                    break;
                case 4:
                    car = new Car(model, Integer.parseInt(carData[2]), carData[3]);
                    break;
            }

            car.setEngine(engines.get(engine));
            cars.add(car);
        }

        cars.forEach(System.out::println);

    }
}
