import java.util.*;

public class HexAndOctal {
    public static void main(String[] args) {
        long l1 = 0x123;
        System.out.println("l1: " + l1);
        System.out.println("l1(binary): " + Long.toBinaryString(l1));

        long l2 = 0123;
        System.out.println("l2: " + l2);
        System.out.println("l2(binary): " + Long.toBinaryString(l2));
    }
}