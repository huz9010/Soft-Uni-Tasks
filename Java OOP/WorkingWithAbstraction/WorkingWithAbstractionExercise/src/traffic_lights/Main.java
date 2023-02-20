package traffic_lights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLight> trafficLights = new ArrayList<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (String e : input)  {
            trafficLights.add(new TrafficLight(Color.valueOf(e)));
        }

        int changes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < changes; i++) {
            for (TrafficLight light : trafficLights)    {
                light.changeColor();
                System.out.print(light + " ");
            }
            System.out.println();
        }
    }
}
