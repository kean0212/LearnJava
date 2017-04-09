import java.util.Arrays;

public class Create3DArrayOfBerylliumSphere {
    private static BerylliumSphere[][][] generate3DArrayOfBerylliumSphere(int row, int column, int third) {
        BerylliumSphere[][][] berylliumSpheres = new BerylliumSphere[row][column][third];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                for (int k = 0; k < third; ++k) {
                    berylliumSpheres[i][j][k] = new BerylliumSphere();
                }
            }
        }
        return berylliumSpheres;
    }

    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int column = Integer.parseInt(args[1]);
        int third = Integer.parseInt(args[2]);
        BerylliumSphere[][][] berylliumSpheres = generate3DArrayOfBerylliumSphere(row, column, third);
        System.out.println(Arrays.deepToString(berylliumSpheres));
    }
}