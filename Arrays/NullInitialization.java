class Test {

}

public class NullInitialization {
    private static Test[][] generateTwoDimensionalArray(int row, int column) {
        Test[][] array = new Test[row][column];
        return array;
    }

    private static void printTwoDimensionalArray(Test[][] array) {
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
        Test[][] array = generateTwoDimensionalArray(row, column);
        printTwoDimensionalArray(array);
    }
}