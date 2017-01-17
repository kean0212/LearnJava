import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        int first = 1;
        int second = 1;
        String result = "1 1";
        for (int i = 0; i < count - 2; ++i) {
            int temp = first + second;
            result += " " + temp;
            first = second;
            second = temp;
        }
        System.out.println(result);
    }
}