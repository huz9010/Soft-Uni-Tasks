package vehicles_extension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;
    private double acFuelConsumption;

    protected VehicleImpl(double fuelQuantity, double fuelConsumption, int tankCapacity)  {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
        this.acFuelConsumption = 0;
    }

    @Override
    public void driveWithAC(double distance)  {
        setFuelConsumption(fuelConsumption + acFuelConsumption);
        if (distance * fuelConsumption > fuelQuantity)  {
            System.out.printf("%s needs refueling%n", getClass().getSimpleName());
        }   else {
            fuelQuantity -= fuelConsumption * distance;
            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), new DecimalFormat("#.##").format(distance));
        }
        setFuelConsumption(fuelConsumption - acFuelConsumption);
    }

    @Override
    public void driveWithoutAC(double distance)  {
        if (distance * fuelConsumption > fuelQuantity)  {
            System.out.printf("%s needs refueling%n", getClass().getSimpleName());
        }   else {
            fuelQuantity -= fuelConsumption * distance;
            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), new DecimalFormat("#.##").format(distance));
        }
    }

    @Override
    public void refuel(double liters)    {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if ((fuelQuantity + liters) > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(this.fuelQuantity + liters);
    }

    @Override
    public String toString()    {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void setAcFuelConsumption(double acFuelConsumption) {
        this.acFuelConsumption = acFuelConsumption;
    }
}
