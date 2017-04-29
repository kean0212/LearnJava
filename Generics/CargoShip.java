import java.util.Random;
import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    private Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random random = new Random(31);

        public Product next() {
            return new Product("test", generatePrice(random));
        }
    };

    public String toString() {
        return "[Product: " + name + " ,Price: " + price + "]";
    }

    private static double generatePrice(Random random) {
        return ((double) ((int) (random.nextDouble() * 10000))) / 100;
    }
}

class Cargo extends ArrayList<Product> {
    private static int counter = 0;
    private int id = counter++;

    public Cargo(int numberOfProducts) {
        Generators.fill(this, Product.generator, numberOfProducts);
    }

    public String toString() {
        return "Cargo " + id + ":" + super.toString() + "\n";
    }
}

public class CargoShip extends ArrayList<Cargo> {
    private String name;

    public CargoShip(String name, int numberOfCargos, int numberOfProductsPerCargo) {
        this.name = name;
        for (int i = 0; i < numberOfCargos; ++i) {
            this.add(new Cargo(numberOfProductsPerCargo));
        }
    }

    public String toString() {
        return "CargoShip " + name + ":\n" + super.toString();
    }

    public static void main(String[] args) {
        String nameOfShip = "Kean0212";
        int numberOfCargos = 4;
        int numberOfProductsPerCargo = 5;
        CargoShip cargoShip = new CargoShip(nameOfShip, numberOfCargos, numberOfProductsPerCargo);
        System.out.println(cargoShip);
    }
}