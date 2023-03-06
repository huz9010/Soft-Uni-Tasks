package wild_farm;

public abstract class Mammal extends Animal  {

    private String livingRegion;

    public String getLivingRegion() {
        return livingRegion;
    }

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }
}
