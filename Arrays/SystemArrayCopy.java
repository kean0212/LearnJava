import java.util.Arrays;

public class SystemArrayCopy {
    private static BerylliumSphere[] createBerylliumSpheres(int size) {
        BerylliumSphere[] spheres = new BerylliumSphere[size];
        for (int i = 0; i < size; ++i) {
            spheres[i] = new BerylliumSphere();
        }
        return spheres;
    }

    public static void main(String[] args) {
        BerylliumSphere[] spheresOne = createBerylliumSpheres(10);
        System.out.println(Arrays.toString(spheresOne));

        // Apply arraycopy()
        BerylliumSphere[] spheresTwo = new BerylliumSphere[10];
        System.out.println("before array copy: " + Arrays.toString(spheresTwo));
        System.arraycopy(spheresOne, 0, spheresTwo, 0, spheresTwo.length);
        System.out.println("after array copy: " + Arrays.toString(spheresTwo));

        // show that it's shallow copy
        System.out.println("the name of the first element of array two: " + spheresTwo[0].name);
        spheresOne[0].name = "hello";
        System.out.println("the name of the first element of array two: " + spheresTwo[0].name);
    }
}