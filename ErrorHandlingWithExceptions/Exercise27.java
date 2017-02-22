import java.util.*;

public class Exercise27 {
    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            System.out.println(array[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Failed to access the element of array due to out of bounds exception!");
            throw new RuntimeException(e);
        }
    }
}