package shapes;

public class Circle extends Shape   {

    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public final double getRadius() {
        return radius;
    }

    private void setRadius(double radius)   {
        this.radius = radius;
    }

    public void calculatePerimeter()    {
        setPerimeter(2 * radius * Math.PI);
    }

    public void calculateArea() {
        setArea(Math.PI * Math.pow(radius, 2));
    }
}
