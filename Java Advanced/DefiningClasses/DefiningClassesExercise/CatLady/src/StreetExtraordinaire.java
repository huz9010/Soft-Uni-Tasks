public class StreetExtraordinaire extends Cat   {

    private final String breed;
    private final double decibelsOfMeows;

    public StreetExtraordinaire(String breed, String name, double decibelsOfMeows) {
        super(name);
        this.breed = breed;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, super.name, this.decibelsOfMeows);
    }
}
