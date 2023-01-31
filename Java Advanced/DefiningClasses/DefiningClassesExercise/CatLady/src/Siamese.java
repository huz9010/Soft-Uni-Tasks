public class Siamese extends Cat    {

    private final String breed;
    private final double earSize;

    public Siamese(String breed, String name, double earSize) {
        super(name);
        this.breed = breed;
        this.earSize = earSize;
    }

    @Override
    public String toString()    {
        return String.format("%s %s %.2f", this.breed, super.name, this.earSize);
    }
}
