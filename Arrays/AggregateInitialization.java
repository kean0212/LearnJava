
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class AggregateInitialization {
    public static void printSpheres(BerylliumSphere[] spheres) {
        for (BerylliumSphere sphere : spheres) {
            System.out.print(sphere + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // this ordinary aggregate initialization should NOT work
//        printSpheres({new BerylliumSphere(), new BerylliumSphere()});

        // this dynamic aggregate initialization should work
        printSpheres(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});

        BerylliumSphere[] spheresOne = {new BerylliumSphere(), new BerylliumSphere()};
        printSpheres(spheresOne);

        // the above example shows that this dynamic aggregate initialization is redundant
        BerylliumSphere[] spheresTwo = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};
        printSpheres(spheresTwo);
    }
}