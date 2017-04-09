import java.util.Arrays;

public class DeepCompareArrays {
    private static CompareTestClass[][] generate2DArray(int row, int column) {
        CompareTestClass[][] compareTestClasses = new CompareTestClass[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                compareTestClasses[i][j] = new CompareTestClass(i * j);
            }
        }
        return compareTestClasses;
    }

    public static void main(String[] args) {
        int row = 3;
        int column = 4;
        CompareTestClass[][] compareTestClassesOne = generate2DArray(row, column);
        System.out.println(compareTestClassesOne + ": " + Arrays.deepToString(compareTestClassesOne));

        CompareTestClass[][] compareTestClassesTwo = generate2DArray(row, column);
        System.out.println(compareTestClassesTwo + ": " + Arrays.deepToString(compareTestClassesTwo));

        System.out.println("array one == array two: " + Arrays.deepEquals(compareTestClassesOne, compareTestClassesTwo));
    }
}