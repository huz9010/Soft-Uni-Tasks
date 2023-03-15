package christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000;
    private static final int MIN_HORSEPOWER = 400;
    private static final int MAX_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    protected boolean isValid(int horsePower) {
        return horsePower >= MIN_HORSEPOWER && horsePower <= MAX_HORSEPOWER;
    }
}
