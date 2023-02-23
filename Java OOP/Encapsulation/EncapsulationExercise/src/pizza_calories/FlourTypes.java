package pizza_calories;

public enum FlourTypes {

    White(1.5),
    Wholegrain(1.0);

    private double modifier;

    FlourTypes(double modifier) {
        this.modifier = modifier;
    }

    public static boolean contains(String test) {
        for (FlourTypes type : values())    {
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
