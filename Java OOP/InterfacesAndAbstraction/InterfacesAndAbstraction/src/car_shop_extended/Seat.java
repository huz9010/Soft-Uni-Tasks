package car_shop_extended;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public String toString()    {
        return String.format("%s%n%s sells for %f",super.toString() , this.getModel(), this.price);
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
