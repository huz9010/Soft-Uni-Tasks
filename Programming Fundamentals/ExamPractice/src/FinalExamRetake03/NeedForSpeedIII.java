package FinalExamRetake03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 1; i <= carCount; i++) {
            String[] carAttributes = scanner.nextLine().split("\\|");
            String car = carAttributes[0];
            int mileage = Integer.parseInt(carAttributes[1]);
            int fuel = Integer.parseInt(carAttributes[2]);

            carMileage.put(car, mileage);
            carFuel.put(car, fuel);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop"))   {
            String[] inputCommand = input.split(" : ");
            String command = inputCommand[0];
            String currentCar = inputCommand[1];

            switch (command)    {
                case "Drive":
                    int distance = Integer.parseInt(inputCommand[2]);
                    int fuel = Integer.parseInt(inputCommand[3]);

                    if (carFuel.get(currentCar) < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    }   else {
                        int currentMileage = carMileage.get(currentCar) + distance;
                        carMileage.put(currentCar, currentMileage);

                        int currentFuel = carFuel.get(currentCar) - fuel;
                        carFuel.put(currentCar, currentFuel);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currentCar, distance, fuel);
                    }
                    if (carMileage.get(currentCar) >= 100000)   {
                        System.out.printf("Time to sell the %s!%n", currentCar);
                        carMileage.remove(currentCar);
                        carFuel.remove(currentCar);
                    }
                    break;
                case "Refuel":
                    int fuelRefill = Integer.parseInt(inputCommand[2]);
                    int currentFuel = carFuel.get(currentCar);
                    int refilledTank = currentFuel + fuelRefill;

                    if (refilledTank > 75)  {
                        refilledTank = 75;
                        fuelRefill = 75 - currentFuel;
                    }

                    carFuel.put(currentCar, refilledTank);

                    System.out.printf("%s refueled with %s liters%n", currentCar, fuelRefill);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(inputCommand[2]);
                    int currentKms = carMileage.get(currentCar) - kilometers;

                    if (currentKms < 10000)     {
                        currentKms = 10000;
                    }   else {
                        System.out.printf("%s mileage decreased by %s kilometers%n", currentCar, kilometers);
                    }
                    carMileage.put(currentCar, currentKms);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : carMileage.entrySet()) {

            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue(), carFuel.get(entry.getKey()));
        }
    }
}
