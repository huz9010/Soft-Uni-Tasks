package vehicles;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        double AC_CONSUMPTION = 0.9;
        super.setFuelConsumption(fuelConsumption + AC_CONSUMPTION);
    }
}
