package shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5, 4);
        Shape circle = new Circle(5);

        rectangle.calculatePerimeter();
        rectangle.calculateArea();
        circle.calculatePerimeter();
        circle.calculateArea();

        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
