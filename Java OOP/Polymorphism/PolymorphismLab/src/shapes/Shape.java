package shapes;

public abstract class Shape {

    private double perimeter;
    private double area;

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();

    public double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }
}
