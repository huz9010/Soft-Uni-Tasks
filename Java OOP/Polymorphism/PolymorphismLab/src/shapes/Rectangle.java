package shapes;

public class Rectangle extends Shape    {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    private void setHeight(double height)   {
        this.height = height;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter()  {
        setPerimeter(height * 2 + width * 2);
    }

    @Override
    public void calculateArea() {
        setArea(height * width);
    }
}
