package vehicles_extension;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setAcFuelConsumption(1.6);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
