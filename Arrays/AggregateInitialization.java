
class BerylliumSphere implements Comparable<BerylliumSphere> {
    private static int counter;
    private int id = counter++;

    public String name; // this is for testing shallow copy

    public String toString() {
        return "Sphere " + id;
    }

    public int getId() {
        return id;
    }

    public int compareTo(BerylliumSphere another) {
        return -(id - another.getId());
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