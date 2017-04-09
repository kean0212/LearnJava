import java.util.Random;

public class GenerateThreeDimensionalArray {
    private static final Random RANDOM = new Random(47);

    private static double generateValue(double minimum, double maximum) {
        double threshold = maximum - minimum;
        return RANDOM.nextDouble() * threshold + minimum;
    }

    private static double[][][] generateThreeDimensionalArray(int row, int column, int third, double minimum, double maximum) {
        double[][][] array = new double[row][column][third];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                for (int k = 0; k < third; ++k) {
                    array[i][j][k] = generateValue(minimum, maximum);
                }
            }
        }
        return array;
    }

    private static void printArray(double[][][] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; ++j) {
                System.out.print("[");
                for (int k = 0; k < array[i][j].length; ++k) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.print("]");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int column = Integer.parseInt(args[1]);
        int third = Integer.parseInt(args[2]);
        double minimum = Double.parseDouble(args[3]);
        double maximum = Double.parseDouble(args[4]);
        double[][][] array = generateThreeDimensionalArray(row, column, third, minimum, maximum);
        printArray(array);
    }
}