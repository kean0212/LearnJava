import java.util.*;

public class VampireNumber {
    public static void main(String[] args) {
        int digitsNumber = Integer.parseInt(args[0]);
        int maximum = (int) Math.pow(10, digitsNumber) - 1;
        int end = (int) Math.pow(10, digitsNumber / 2) - 1;
        int start = (end + 1) / 10;
        int middle = (start + end) / 2;
        outer:
        for (int i = start; i <= end; ++i) {
            for (int j = i; j <= end; ++j) {
                if (i * j > maximum) {
                    continue outer;
                } else {
                    int product = i * j;
                    if (isVampireNumber(i, j, product)) {
                        System.out.println("" + i + " " + j + " " + product);
                    }
                }
            }
        }
    }

    private static boolean isVampireNumber(int i, int j, int product) {
        int[] counts = new int[10];

        char[] array = ("" + i).toCharArray();
        for (int k = 0; k < array.length; ++k) {
            counts[array[k] - '0']++;
        }

        array = ("" + j).toCharArray();
        for (int k = 0; k < array.length; ++k) {
            counts[array[k] - '0']++;
        }

        array = ("" + product).toCharArray();
        for (int k = 0; k < array.length; ++k) {
            counts[array[k] - '0']--;
        }

        for (int k = 0; k < 10; ++k) {
            if (counts[k] != 0) {
                return false;
            }
        }

        return true;
    }
}