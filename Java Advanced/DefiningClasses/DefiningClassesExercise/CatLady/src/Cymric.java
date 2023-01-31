public class Cymric extends Cat {

    private final String breed;
    private final double furLength;

    public Cymric(String breed, String name, double furLength) {
        super(name);
        this.breed = breed;
        this.furLength = furLength;
    }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", this.breed, super.name, this.furLength);
        }
}
