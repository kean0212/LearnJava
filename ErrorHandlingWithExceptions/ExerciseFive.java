import java.util.*;

public class ExerciseFive {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            try {
                if (i - 10 < 0) {
                    throw new Exception("i is less than 10.");
                } else {
                    System.out.println("i is greater than or equal to 10.");
                    break; // the scope is the same as without try block
                }
            } catch (Exception exception) {
                System.out.println("i is less than 10; automatically incremented by 1.");
                i++;
                continue; // the scope is the same as without catch block
            }
        }
    }
}