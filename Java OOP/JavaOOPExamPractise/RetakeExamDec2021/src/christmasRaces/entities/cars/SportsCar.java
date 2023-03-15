package christmasRaces.entities.cars;

public class SportsCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 3000;
    private static final int MIN_HORSEPOWER = 250;
    private static final int MAX_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    protected boolean isValid(int horsePower) {
        return horsePower >= MIN_HORSEPOWER && horsePower <= MAX_HORSEPOWER;
    }
}
