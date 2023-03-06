package wild_farm;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected abstract void makeSound();
    protected abstract void eat(Food food);

    protected int getFoodEaten() {
        return foodEaten;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected double getAnimalWeight() {
        return animalWeight;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }
}
