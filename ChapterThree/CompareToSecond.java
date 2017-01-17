import java.util.*;

public class CompareToSecond {
    public static void main(String[] args) {
        Random random = new Random(212);
        int first = random.nextInt();
        int second = random.nextInt();
        System.out.println(first + " " + compareTwoInts(first, second) + " " + second);
        System.out.println("second: " + second);

        for (int i = 0; i < 23; ++i) {
            int current = random.nextInt();
            System.out.println(current + " " + compareTwoInts(current, second) + " " + second);
        }
    }

    static private String compareTwoInts(int first, int second) {
        if (first > second) {
            return "greater";
        } else if (first < second) {
            return "less";
        } else {
            return "equal";
        }
    }
}