public class Car {


    private String model;
    private double fuel;
    private double fuelConsumption;
    int mileage;

    public Car(String model, double fuel, double fuelConsumption) {
        this.model = model;
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.mileage = 0;
    }

    public void drive(int km)   {
        if (fuel < km * fuelConsumption)    {
            System.out.println("Insufficient fuel for the drive");
        }   else {
            mileage += km;
            fuel -= fuelConsumption * km;
        }
    }
    @Override
    public String toString()    {
        return String.format("%s %.2f %d", this.model, this.fuel, this.mileage);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
