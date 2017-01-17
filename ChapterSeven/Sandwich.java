import java.util.*;

class Meal {
    Meal() {
        System.out.println("Meal");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce");
    }
}

class Pickle {
    Pickle() {
        System.out.println("Pickle");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch");
    }
}

class Sandwich extends PortableLunch {
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();
    private Pickle pickle = new Pickle();

    public Sandwich() {
        System.out.println("Sandwich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
