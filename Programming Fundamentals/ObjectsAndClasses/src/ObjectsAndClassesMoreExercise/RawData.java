package ObjectsAndClassesMoreExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int carCount = Integer.parseInt(reader.readLine());

        Garage garage = new Garage();
        for (int i = 0; i < carCount; i++) {
            String[] carData = reader.readLine().split("\\s+");
            Car car = createCar(carData);
            garage.addCar(car);
        }

        String command = reader.readLine();

        if (command.equals("fragile"))  {
            printFragileCars(garage);
        } else if (command.equals("flamable")) {
            printFlamableCars(garage);
        }

    }

    private static void printFlamableCars(Garage garage) {
        List<Car> fragileCars =  garage.getCars().stream().filter(e -> e.getCargo().getType().equals("flamable")).collect(Collectors.toList());
        for (Car car : fragileCars)    {
            if (car.getEngine().getPower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }

    private static void printFragileCars(Garage garage) {
        List<Car> fragileCars =  garage.getCars().stream().filter(e -> e.getCargo().getType().equals("fragile")).collect(Collectors.toList());
        for (Car car : fragileCars)    {
            if (car.getTires().stream().anyMatch(e -> e.getPressure() < 1)) {
                System.out.println(car.getModel());
            }
        }
    }

    private static Car createCar(String[] carData) {
        String model = carData[0];
        int engineSpeed = Integer.parseInt(carData[1]);
        int enginePower = Integer.parseInt(carData[2]);
        int cargoWeight = Integer.parseInt(carData[3]);
        String cargoType = carData[4];

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoType, cargoWeight);

        Collection<Tire> tires = new ArrayList<>();

        for (int i = 5; i < carData.length; i++) {
            double tirePressure = Double.parseDouble(carData[i]);
            int tireAge = Integer.parseInt(carData[i + 1]);
            tires.add(new Tire(tirePressure, tireAge));
            i++;
        }
        return new Car(model, engine, cargo, tires);
    }

    public static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private Collection<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo, Collection<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public Collection<Tire> getTires() {
            return tires;
        }
    }

    public static class Engine {
        private int speed;
        private int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Cargo {
        private String type;
        private int weight;

        public Cargo(String type, int weight) {
            this.type = type;
            this.weight = weight;
        }

        public String getType() {
            return type;
        }
    }

    public static class Tire {
        private double pressure;
        private int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return pressure;
        }
    }

    public static class Garage {
        private Collection<Car> cars;

        public Garage() {
            this.cars = new ArrayList<>();
        }

        public Collection<Car> getCars() {
            return cars;
        }

        public void addCar(Car car) {
            cars.add(car);
        }
    }

}
