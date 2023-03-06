package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    protected VehicleImpl(double fuelQuantity, double fuelConsumption)  {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    @Override
    public void drive(double distance)  {
        if (distance * fuelConsumption > fuelQuantity)  {
            System.out.printf("%s needs refueling%n", getClass().getSimpleName());
        }   else {
            fuelQuantity -= fuelConsumption * distance;
            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), new DecimalFormat("#.##").format(distance));
        }
    }

    @Override
    public void refuel(double liters)    {
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
}
