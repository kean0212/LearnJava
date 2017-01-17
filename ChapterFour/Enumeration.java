import java.util.*;

enum Color{
        BLUE,YELLOW,RED,PURPLE
        }

public class Enumeration {
    static void printDescription(Color color) {
        switch (color) {
            case BLUE:
                System.out.println("This is blue");
                break;
            case YELLOW:
                System.out.println("This is yellow");
                break;
            case RED:
                System.out.println("This is red");
                break;
            case PURPLE:
                System.out.println("This is purple");
                break;
            default:
                System.out.println("Not defined");
        }
    }
    public static void main(String[] args) {
        for (Color color : Color.values()) {
//            System.out.println(color + " ordinal: " + color.ordinal());
            printDescription(color);
        }
    }
}