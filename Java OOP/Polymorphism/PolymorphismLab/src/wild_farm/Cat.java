package wild_farm;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override

    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food)  {
        super.setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString()    {

        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %s]",
                getAnimalType(), getAnimalName(), breed, df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
