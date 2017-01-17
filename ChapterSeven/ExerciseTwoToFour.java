import exerciseTwoToFour.*;

public class ExerciseTwoToFour {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[7];
        for (int i = 0; i < 7; ++i) {
            shapes[i] = ShapeGenerator.next();
        }
        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.render();
        }
    }
}