import java.util.*;
import java.lang.reflect.Field;

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

public class Exercise9 {
    static void printAllAncestors (Object object) {
        Class classObject = object.getClass();
        while (classObject != null) {
            System.out.println(classObject.getSimpleName());

            System.out.println("Fields are: ");
            for (Field field : classObject.getDeclaredFields()) {
                System.out.println(field.getName());
            }

            classObject = classObject.getSuperclass();
        }
    }
    public static void main(String[] args) {
        printAllAncestors(new Triangle());
    }
}