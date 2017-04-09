import java.util.Random;

public class GenerateTwoDimensionalArray {
    private static final Random RANDOM = new Random(47);

    private static double generateValue(double minimum, double maximum) {
        double threshold = maximum - minimum;
        return RANDOM.nextDouble() * threshold + minimum;
    }

    private static double[][] generateTwoDimensionalArray(int row, int column, double minimum, double maximum) {
        double[][] array = new double[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                array[i][j] = generateValue(minimum, maximum);
            }
        }
        return array;
    }

    private static void printArray(double[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int column = Integer.parseInt(args[1]);
        double minimum = Double.parseDouble(args[2]);
        double maximum = Double.parseDouble(args[3]);
        double[][] array = generateTwoDimensionalArray(row, column, minimum, maximum);
        printArray(array);
    }
}