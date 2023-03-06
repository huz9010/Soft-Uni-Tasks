package wild_farm;

import java.text.DecimalFormat;

public class Zebra extends Mammal   {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food)  {
        if (!food.getClass().getSimpleName().equals("Vegetable"))    {
            System.out.println("Zebras are not eating that type of food!");
        }   else {
            super.setFoodEaten(getFoodEaten() + food.getQuantity());
        }
    }

    @Override
    public String toString()    {

        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s]",
                getAnimalType(), getAnimalName(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
