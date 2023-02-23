package pizza_calories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories()   {
        return 2 * weight * ToppingTypes.valueOf(toppingType).getModifier();
    }

    private void setToppingType(String toppingType) {
        if (!ToppingTypes.contains(toppingType))    {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50)  {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }
}
