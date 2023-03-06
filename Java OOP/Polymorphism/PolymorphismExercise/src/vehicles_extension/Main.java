package vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carData = reader.readLine().split("\\s+");
        String[] truckData = reader.readLine().split("\\s+");
        String[] busData = reader.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), Integer.parseInt(carData[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]), Integer.parseInt(truckData[3]));
        Vehicle bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]), Integer.parseInt(busData[3]));

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);
        
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            double value = Double.parseDouble(input[2]);

            if (command.equals("Drive")) {
                vehicles.get(vehicleType).driveWithAC(value);
            } else if (command.equals("DriveEmpty")) {
                vehicles.get(vehicleType).driveWithoutAC(value);
            } else {
                try {
                    vehicles.get(vehicleType).refuel(value);
                }   catch (IllegalArgumentException e)  {
                    System.out.println(e.getMessage());
                }
            }
        }

        vehicles.values().forEach(System.out::println);
    }
}
