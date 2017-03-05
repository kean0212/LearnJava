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

public class Exercise8 {
    static void printAllAncestors (Object object) {
        Class classObject = object.getClass();
        while (classObject.getSuperclass() != null) {
            Class superClass = classObject.getSuperclass();
            System.out.println(superClass.getSimpleName());
            System.out.println(superClass.getName());
            System.out.println(superClass.getCanonicalName());
            classObject = superClass;
        }
    }
    public static void main(String[] args) {
        printAllAncestors(new Triangle());
    }
}