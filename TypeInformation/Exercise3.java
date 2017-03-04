import java.util.*;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );

        for (Shape shape : shapeList) {
            shape.draw();
//            if (shape instanceof Rhomboid) {
//                ((Circle)shape).draw(); // cannot be cast to Circle
//            }
            if (shape.getClass() == Rhomboid.class) {
                System.out.print(shape.getClass().getSimpleName());
                ((Circle)shape).draw(); // cannot be cast to Circle
            }
        }
    }
}
