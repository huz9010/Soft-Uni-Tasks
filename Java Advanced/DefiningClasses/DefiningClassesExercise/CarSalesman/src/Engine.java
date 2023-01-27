public class Engine {

//    /    A Car has a model, engine, weight, and color.
////    An Engine has a model, power, displacement, and efficiency.
////    A Car's weight, color, Engine displacements, and efficiency are optional.

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    //V4-33:
//Power: 140
//Displacement: 28
//Efficiency: B

    @Override
    public String toString() {
        if (this.displacement != -1) {
            return String.format("%s:%n" +
                    "Power: %d%n" +
                    "Displacement: %d%n" +
                    "Efficiency: %s", this.model, this.power, this.displacement, this.efficiency);
        } else {
            return String.format("%s:%n" +
                    "Power: %d%n" +
                    "Displacement: n/a%n" +
                    "Efficiency: %s", this.model, this.power, this.efficiency);
        }
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
