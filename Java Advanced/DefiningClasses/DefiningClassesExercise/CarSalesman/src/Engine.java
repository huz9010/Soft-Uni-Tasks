public class Engine {

//    /    A Car has a model, engine, weight, and color.
////    An Engine has a model, power, displacement, and efficiency.
////    A Car's weight, color, Engine displacements, and efficiency are optional.

    private String model;
    private int power;
    private int displacement;
    private char efficiency;

    public Engine(String model, int power, int displacement, char efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
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

    public char getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(char efficiency) {
        this.efficiency = efficiency;
    }
}
