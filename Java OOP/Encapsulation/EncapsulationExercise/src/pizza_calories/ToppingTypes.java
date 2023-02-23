package pizza_calories;

public enum ToppingTypes {

    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double modifier;

    ToppingTypes(double modifier) {
        this.modifier = modifier;
    }

    public static boolean contains(String test)    {
        for (ToppingTypes type : values())  {
            if (type.name().equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }

    public double getModifier() {
        return modifier;
    }
}
