package need_for_speed;

public class Vehicle {

    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    protected double fuelConsumption;
    protected double fuel;
    protected int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public void drive(double kilometers)    {
        if (fuel < kilometers * fuelConsumption)    {
            throw new IllegalStateException("Insufficient fuel.");
        }   else {
            fuel -= kilometers * fuelConsumption;
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
