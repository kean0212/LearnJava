import java.util.*;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    void rotate() {
        if (this.getClass() != Circle.class) {
            System.out.println(this.getClass().getSimpleName() + ".rotate()");
        }
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

public class Exercise5 {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );

        for (Shape shape : shapeList) {
            shape.rotate();
        }
    }
}
