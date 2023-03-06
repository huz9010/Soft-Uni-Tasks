package vehicles;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        double AC_CONSUMPTION = 1.6;
        super.setFuelConsumption(fuelConsumption + AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
