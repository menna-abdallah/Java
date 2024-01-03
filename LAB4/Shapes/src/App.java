
import java.util.ArrayList;
import java.util.List;

// Base class Shape 
abstract class Shape {
    abstract void draw();
}

// class Rectangle extending Shape
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

//  class Circle extending Shape
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class ShapeTest {
    // Method to accept a list a list of any subtype of Shape.
    public static void drawShapes(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

// App class

public class App {
    public static void main(String[] args) {
        // Creating ArrayList of Rectangle and Circle
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());

        // Testing the generic method with ArrayList of Rectangle
        System.out.println("Drawing Rectangles:");
        drawShapes(rectangles);

        // Testing the generic method with ArrayList of Circle
        System.out.println("\nDrawing Circles:");
        drawShapes(circles);
    }
}
