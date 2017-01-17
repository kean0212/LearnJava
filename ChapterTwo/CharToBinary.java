import java.util.*;

public class CharToBinary {
    public static void main(String[] args) {
        char charOne = 'a';
        System.out.println("a: " + charToBinary(charOne));

        char charTwo = 'b';
        System.out.println("b: " + charToBinary(charTwo));

        char charThree = 'c';
        System.out.println("c: " + charToBinary(charThree));

        char charFour = 'd';
        System.out.println("d: " + charToBinary(charFour));
    }

    static private String charToBinary(char character) {
        int number = (int) character;
        return Integer.toBinaryString(number);
    }
}