import java.util.*;

public class SignedRightShift {
    public static void main(String[] args) {
       int number = 0x80000000;

       for (int i = 0; i < 32; number >>= 1, ++i) {
           System.out.println(Integer.toBinaryString(number));
       }
    }
}