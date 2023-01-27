public class Car {

//    A Car has a model, engine, weight, and color.
//    An Engine has a model, power, displacement, and efficiency.
//    A Car's weight, color, Engine displacements, and efficiency are optional.

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    //    FordFocus:
//V4-33:
//Power: 140
//Displacement: 28
//Efficiency: B

//Weight: 1300
//Color: Silver


    @Override
    public String toString()    {
        if (this.weight != -1) {
            return String.format("%s:%n" +
                    "%s%n" +
                    "Weight: %d%n" +
                    "Color: %s", this.model, this.engine, this.weight, this.color);
        }   else {
            return String.format("%s:%n" +
                    "%s%n" +
                    "Weight: n/a%n" +
                    "Color: %s", this.model, this.engine, this.color);
        }
    }

    public Car(String model, int weight, String color) {
        this.model = model;
        this.weight = weight;
        this.color = color;
    }


    public Car(String model, int weight) {
        this(model, weight,"n/a");

    }

    public Car(String model, String color) {
        this(model, -1, color);
    }

    public Car(String model) {
        this(model, -1, "n/a");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
