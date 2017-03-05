import java.util.*;

abstract class Shape {
    boolean isHighlighted = false;

    void draw() {
        System.out.println(this + ".draw()");
    }
}

class Circle extends Shape {
    public String toString() {
        return (isHighlighted ? "Highlighed: " : "") + "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return (isHighlighted ? "Highlighed: " : "") + "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return (isHighlighted ? "Highlighed: " : "") + "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return (isHighlighted ? "Highlighed: " : "") + "Rhomboid";
    }
}

public class Exercise6 {
    static void setHighlighted(Shape shape) {
        if (shape instanceof Triangle) {
            shape.isHighlighted = true;
        }
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );

        for (Shape shape : shapeList) {
            setHighlighted(shape);
            System.out.println(shape);
        }
    }
}
