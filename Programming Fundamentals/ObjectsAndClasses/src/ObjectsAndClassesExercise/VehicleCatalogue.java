package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public void setVehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }
    }

    public static void printVehicle(List<Vehicle> vehicleList, String inputModel)   {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getModel().equals(inputModel))  {
                String type = vehicle.getType().substring(0 ,1).toUpperCase() + vehicle.getType().substring(1);
                System.out.printf("Type: %s%n" +
                        "Model: %s%n" +
                        "Color: %s%n" +
                        "Horsepower: %d%n", type, vehicle.getModel(), vehicle.getColor(), vehicle.getHorsepower());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        while (!input.equals("End"))    {
            String[] vehicleData = input.split(" ");
            String type = vehicleData[0];
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsepower = Integer.parseInt(vehicleData[3]);

            Vehicle currentVehicle = new Vehicle();
            currentVehicle.setVehicle(type, model, color, horsepower);
            vehicleList.add(currentVehicle);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue"))    {
            printVehicle(vehicleList, input);
            input = scanner.nextLine();
        }
        int totalCarHorsepower = 0;
        int totalTruckHorsepower = 0;
        int carCount = 0;
        int truckCount = 0;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getType().equals("car"))    {
                totalCarHorsepower += vehicle.getHorsepower();
                carCount++;
        } else if (vehicle.getType().equals("truck")) {
                totalTruckHorsepower += vehicle.getHorsepower();
                truckCount++;
            }
            }
            double avgCarHorsepower = 0;
            double avgTruckHorsepower = 0;

            if (carCount > 0) {
                avgCarHorsepower = totalCarHorsepower * 1.0 / carCount;
            }
            if (truckCount > 0) {
                avgTruckHorsepower = totalTruckHorsepower * 1.0 / truckCount;
            }
        System.out.printf("Cars have average horsepower of: %.2f.%n" +
                "Trucks have average horsepower of: %.2f.%n", avgCarHorsepower, avgTruckHorsepower);
    }
}
