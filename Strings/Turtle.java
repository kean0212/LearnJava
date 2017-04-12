import java.util.Formatter;
import java.io.PrintStream;

public class Turtle {
    private String name;
    private Formatter formatter;

    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s The turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(3, 0);
        terry.move(3, 0);
        tommy.move(2, 4);
        terry.move(2, 4);
        tommy.move(5, 2);
        terry.move(5, 2);
    }
}