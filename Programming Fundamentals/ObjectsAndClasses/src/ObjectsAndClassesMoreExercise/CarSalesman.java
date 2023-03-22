package ObjectsAndClassesMoreExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EngineRepository engines = new EngineRepository();
        int enginesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < enginesCount; i++) {
            Engine engine = createEngine(reader);
            engines.add(engine.getModel(), engine);
        }

        CarRepository cars = new CarRepository();
        int carsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < carsCount; i++) {
            Car car = createCar(reader, engines);
            cars.add(car.getModel(), car);
        }

        cars.getCars().forEach(System.out::println);
    }

    private static Car createCar(BufferedReader reader, EngineRepository engines) throws IOException {
        String[] carData = reader.readLine().split("\\s+");
        String model = carData[0];
        Engine engine = engines.getEngines().get(carData[1]);
        Car car = null;

        if (carData.length == 4)    {
            int weight = Integer.parseInt(carData[2]);
            String color = carData[3];
            car = new Car(model, engine, weight, color);

        } else if (carData.length == 3) {
            if (Character.isDigit(carData[2].charAt(0)))    {
                int weight = Integer.parseInt(carData[2]);
                car = new Car(model, engine, weight);
            }   else {
                String color = carData[2];
                car = new Car(model, engine, color);
            }

        } else if (carData.length == 2) {
            car = new Car(model, engine);
        }
        return car;
    }

    private static Engine createEngine(BufferedReader reader) throws IOException {
        String[] engineData = reader.readLine().split("\\s+");
        String model = engineData[0];
        int power = Integer.parseInt(engineData[1]);
        Engine engine = null;

        if (engineData.length == 4) {
            int displacement = Integer.parseInt(engineData[2]);
            String efficiency = engineData[3];
            engine = new Engine(model, power, displacement, efficiency);

        } else if (engineData.length == 3) {
            if (Character.isDigit(engineData[2].charAt(0))) {
                int displacement = Integer.parseInt(engineData[2]);
                engine = new Engine(model, power, displacement);
            }   else {
                String efficiency = engineData[2];
                engine = new Engine(model, power, efficiency);
            }

        } else if (engineData.length == 2) {
            engine = new Engine(model, power);
        }
        return engine;
    }

    public static class Car {
        private static final String MISSING_PARAMETER = "n/a";
        private String model;
        private Engine engine;
        private int weight;
        private String color;

        public Car(String model, Engine engine, int weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        public Car(String model, Engine engine, int weight) {
            this(model, engine, weight, MISSING_PARAMETER);
        }

        public Car(String model, Engine engine, String color) {
            this(model, engine, 0, color);
        }

        public Car(String model, Engine engine) {
            this(model, engine, 0, MISSING_PARAMETER);
        }

        public String getModel() {
            return model;
        }

        @Override
        public String toString() {
            String weightString;
            if (weight == 0)    {
                weightString = MISSING_PARAMETER;
            }   else {
                weightString = String.valueOf(weight);
            }
            return String.format("%s:%n" +
                    "  %s%n" +
                    "  Weight: %s%n" +
                    "  Color: %s", this.model, this.engine, weightString, this.color);
        }
    }

    public static class Engine {
        private static final String MISSING_PARAMETER = "n/a";
        private String model;
        private int power;
        private int displacement;
        private String efficiency;

        public Engine(String model, int power, int displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public Engine(String model, int power, int displacement) {
            this(model, power, displacement, MISSING_PARAMETER);
        }

        public Engine(String model, int power, String efficiency) {
            this(model, power, 0, efficiency);
        }

        public Engine(String model, int power) {
            this(model, power, 0 ,MISSING_PARAMETER);
        }

        public String getModel() {
            return model;
        }


        @Override
        public String toString() {
            String displacementString;
            if (displacement == 0)  {
                displacementString = MISSING_PARAMETER;
            }   else {
                displacementString = String.valueOf(displacement);
            }
            return String.format("%s:%n" +
                            "    Power: %d%n" +
                            "    Displacement: %s%n" +
                    "    Efficiency: %s", this.model, this.power, displacementString, this.efficiency);
        }

    }

    public static class EngineRepository {
        private Map<String, Engine> engines;

        public EngineRepository() {
            this.engines = new HashMap<>();
        }

        public Map<String, Engine> getEngines() {
            return engines;
        }

        public void add(String model, Engine engine)    {
            this.engines.put(model, engine);
        }

    }

    public static class CarRepository {
        private List<Car> cars;

        public CarRepository() {
            this.cars = new ArrayList<>();
        }

        public List<Car> getCars() {
            return cars;
        }

        public void add(String model, Car car) {
            cars.add(car);
        }
    }
}
