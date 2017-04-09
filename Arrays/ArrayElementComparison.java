import java.util.Arrays;
import java.util.Comparator;

class BerylliumSphereComparator implements Comparator<BerylliumSphere> {
    public int compare(BerylliumSphere sphereOne, BerylliumSphere sphereTwo) {
        return sphereOne.getId() - sphereTwo.getId();
    }
}

public class ArrayElementComparison {
    public static void main(String[] args) {
        int size = 10;
        BerylliumSphere[] spheres = new BerylliumSphere[size];
        for (int i = 0; i < size; ++i) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println("original array: " + Arrays.toString(spheres));

        // Approach one - use the Comparable interface
        Arrays.sort(spheres);
        System.out.println("after sort: " + Arrays.toString(spheres));

        // Approach two - use an Comparator class
        Arrays.sort(spheres, new BerylliumSphereComparator());
        System.out.println("after sort: " + Arrays.toString(spheres));
    }
}