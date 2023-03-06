package vehicles_extension;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setAcFuelConsumption(0.9);
    }

}
