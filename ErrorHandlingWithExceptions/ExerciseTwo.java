import java.util.*;

public class ExerciseTwo {
    public static void main(String[] args) {
        Integer integer = null;
        try {
            System.out.println(integer.equals(3));
        } catch (NullPointerException exception) {
            System.out.println("A NullPointerException is caught!");
        }
    }
}