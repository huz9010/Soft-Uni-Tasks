public class Car {

//    A Car has a model, engine, weight, and color.
//    An Engine has a model, power, displacement, and efficiency.
//    A Car's weight, color, Engine displacements, and efficiency are optional.

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, String weight, String color) {
        this.model = model;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, String weight) {
        this(model, weight,"n/a");

    }

    public Car(String model, String color) {
        this(model, "n/a", color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
