package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        List<Animal> animalList = new ArrayList<>();

        while (!input.equals("End")) {

            String[] animalData = input.split("\\s+");

            String[] foodData = reader.readLine().split("\\s+");

            Animal animal = createAnimal(animalData);
            animal.makeSound();
            Food food = createFood(foodData);
            animal.eat(food);

            animalList.add(animal);

            input = reader.readLine();
        }

        animalList.forEach(System.out::println);
    }

    public static Animal createAnimal(String[] animalData)   {
        Animal animal = null;
        String type = animalData[0];
        String name = animalData[1];
        double weight = Double.parseDouble(animalData[2]);
        String region = animalData[3];

        switch (type)   {
            case "Mouse":
                animal = new Mouse(name, type, weight, region);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, region);
                break;
            case "Cat":
                String breed = animalData[4];
                animal = new Cat(name, type, weight, region, breed);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, region);
                break;
        }
        return animal;
    }

    public static Food createFood(String[] foodData)    {
        Food food;
        String foodType = foodData[0];
        int quantity = Integer.parseInt(foodData[1]);

        if (foodType.equals("Meat"))    {
            food = new Meat(quantity);
        }   else {
            food = new Vegetable(quantity);
        }
        return food;
    }
}
