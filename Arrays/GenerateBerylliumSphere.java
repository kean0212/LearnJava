public class GenerateBerylliumSphere {
    private static BerylliumSphere[] generateBerylliumSpheres(int number) {
        BerylliumSphere[] spheres = new BerylliumSphere[number];
        for (int i = 0; i < number; ++i) {
            spheres[i] = new BerylliumSphere();
        }
        return spheres;
    }

    private static void printSpheres(BerylliumSphere[] spheres) {
        for (BerylliumSphere sphere : spheres) {
            System.out.print(sphere + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        BerylliumSphere[] spheres = generateBerylliumSpheres(number);
        printSpheres(spheres);
    }
}