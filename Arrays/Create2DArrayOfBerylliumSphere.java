import java.util.Arrays;

public class Create2DArrayOfBerylliumSphere {
    private static BerylliumSphere[][] generate2DArrayOfBerylliumSphere(int row, int column) {
        BerylliumSphere[][] berylliumSpheres = new BerylliumSphere[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                berylliumSpheres[i][j] = new BerylliumSphere();
            }
        }
        return berylliumSpheres;
    }

    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int column = Integer.parseInt(args[1]);
        BerylliumSphere[][] berylliumSpheres = generate2DArrayOfBerylliumSphere(row, column);
        System.out.println(Arrays.deepToString(berylliumSpheres));
    }
}