package vehicles_extension;

public class Bus extends VehicleImpl {

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setAcFuelConsumption(1.4);
    }

}
