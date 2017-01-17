import java.util.*;

public class SignedLeftShift {
    public static void main(String[] args) {
        int number = 0xffffffff;

        for (int i = 0; i < 32; number <<= 1, ++i) {
            System.out.println(Integer.toBinaryString(number));
        }
    }
}