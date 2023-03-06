package wild_farm;

import java.text.DecimalFormat;

public class Mouse extends Mammal   {

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food)  {
        if (!food.getClass().getSimpleName().equals("Vegetable"))    {
            System.out.println("Mice are not eating that type of food!");
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
