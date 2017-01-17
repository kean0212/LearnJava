import java.util.*;

public class PrimeNumberBruteForce {
    public static void main(String[] args) {
        outer:
        for (int i = 2; i < 100; ++i) {
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            System.out.println(i +"is a prime number");
        }
    }
}