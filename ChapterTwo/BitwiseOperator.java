import java.util.*;

public class BitwiseOperator {
    public static void main(String[] args) {
        final int constantOne = 0xaaaaaaaa;
        final int constantTwo = 0x55555555;

        System.out.println("constantOne: " + Integer.toBinaryString(constantOne));
        System.out.println("constantTwo: " + Integer.toBinaryString(constantTwo));
        System.out.println("constantOne & constantTwo: " + Integer.toBinaryString(constantOne & constantTwo));
        System.out.println("constantOne | constantTwo: " + Integer.toBinaryString(constantOne | constantTwo));
        System.out.println("~constantOne: " + Integer.toBinaryString(~constantOne));
        System.out.println("~constantTwo: " + Integer.toBinaryString(~constantTwo));
    }
}